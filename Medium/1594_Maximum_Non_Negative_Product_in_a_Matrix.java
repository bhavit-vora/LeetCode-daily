/*
    TC: O(n * m)
    SC: O(n * m)
*/

class Solution {
    long ans = Long.MIN_VALUE;

    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];

        max[0][0] = grid[0][0];
        min[0][0] = grid[0][0];

        for(int i = 1; i < m; ++i) {
            max[i][0] = max[i-1][0] * grid[i][0];
            min[i][0] = max[i][0];
        }

        for(int i=1; i < n; ++i) {
            max[0][i] = max[0][i-1] * grid[0][i];
            min[0][i] = max[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long a = max[i - 1][j] * grid[i][j];
                long b = max[i][j - 1] * grid[i][j];
                long c = min[i - 1][j] * grid[i][j];
                long d = min[i][j - 1] * grid[i][j];
                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
            }
        }
        
        if (Math.max(max[m - 1][n - 1], min[m - 1][n - 1]) < 0)
            return -1;
        return (int) (Math.max(max[m - 1][n - 1], min[m - 1][n - 1]) % 1_000_000_007);
    }
}