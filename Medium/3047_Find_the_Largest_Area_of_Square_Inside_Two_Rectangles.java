/*
    TC: O(n * n)
    SC: O(1)
*/

class Solution {
    public long largestSquareArea(int[][] bl, int[][] tr) {
        int n = bl.length;
        long ans = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = i+1; j < n; j ++) {
                int x = Math.min(tr[i][0], tr[j][0]) - Math.max(bl[i][0], bl[j][0]);
                int y = Math.min(tr[i][1], tr[j][1]) - Math.max(bl[i][1], bl[j][1]);
                ans = Math.max(ans, Math.min(x, y));
            }
        }

        return ans * ans;
    }
}