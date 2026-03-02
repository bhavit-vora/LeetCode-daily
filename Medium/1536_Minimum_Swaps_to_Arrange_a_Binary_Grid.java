/*
    TC: O(n ^ 2)
    SC: O(n)
*/

class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] lastOne = new int[n];

        for(int i = 0; i < n; i ++) {
            int last = -1;
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == 1) last = j;
            }
            lastOne[i] = last;
        }

        int ans = 0;
        for(int i = 0; i < n; ++i) {
            int idx = -1;
            for(int j = i; j < n; j ++) {
                if(lastOne[j] <= i) {
                    idx = j;
                    break;
                }
            }

            if(idx == -1) return -1;

            for(int j = idx; j > i; --j) {
                int temp = lastOne[j];
                lastOne[j] = lastOne[j-1];
                lastOne[j-1] = temp;
                ans++;
            }
        }

        return ans;
    }
}