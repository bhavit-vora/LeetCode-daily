/*
    n = grid.length;
    m = grid[0].length;
    TC: O(n * logm)
    SC: O(1)
*/

class Solution {
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        for(int i = 0; i < grid.length; i ++) {
            int low = 0;
            int high = grid[0].length-1;

            while(low <= high) {
                int mid = low + (high - low) / 2;

                if(grid[i][mid] >= 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            cnt += grid[0].length - low;
        }

        return cnt;
    }
}