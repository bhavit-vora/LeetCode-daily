/*
    TC: O(n * m)
    SC: O(n * m)
*/

class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int n = grid.length;
        int m = grid[0].length;

        long[] pref = new long[n * m];
        long[] suff = new long[n * m];
        pref[0] = grid[0][0] % mod;
        suff[n * m - 1] = grid[n-1][m-1] % mod;

        for(int i = 1; i < n * m; ++ i) pref[i] = (pref[i-1] * grid[i / m][i % m]) % mod;
        for(int i = n * m - 2; i >= 0; -- i) suff[i] = (suff[i+1] * grid[i / m][i % m]) % mod;
        grid[0][0] = (int) suff[1] ;
        grid[n-1][m-1] = (int) pref[n * m - 2];

        for(int i = 1; i < n * m - 1; ++ i) {
            grid[i / m][i % m] = (int)((pref[i-1] * suff[i+1]) % mod);
        }

        return grid;
    }
}