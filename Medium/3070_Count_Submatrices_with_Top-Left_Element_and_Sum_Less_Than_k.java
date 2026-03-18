/*
    TC: O(n * m)
    SC: O(n * m)
*/

class Solution {
    public int countSubmatrices(int[][] grid, int k) {

        if(grid[0][0] > k) return 0;

        int n = grid.length;
        int m = grid[0].length;

        int cnt = 1;
        int[][] pref = new int[n][m];
        pref[0][0] = grid[0][0];

        for(int i = 1; i < n; ++ i) {
            pref[i][0] = pref[i-1][0] + grid[i][0];
            if(pref[i][0] <= k) cnt++;
        }

        for(int j = 1; j < m; ++ j) {
            pref[0][j] = pref[0][j-1] + grid[0][j];
            if(pref[0][j] <= k) cnt++;
        }

        for(int i = 1; i < n; ++ i) {
            for(int j = 1; j < m; ++ j) {
                pref[i][j] = grid[i][j] + pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1];
                if(pref[i][j] <= k) cnt++;
            }
        }

        return cnt;
    }
}