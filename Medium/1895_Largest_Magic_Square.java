/*
    TC: O(min(n, m) * n * m * (m + n))
    SC: O(4 * n * m)
*/

class Solution {
    public boolean check(int r, int c, int len, int[][] rows, int[][] cols, int[][] diag, int[][] anti) {
        int t = c == 0? rows[r][c + len - 1]: rows[r][c + len - 1] - rows[r][c - 1];

        for(int i = r; i < r + len; i ++) {
            int val = c == 0? rows[i][c + len - 1]: rows[i][c + len - 1] - rows[i][c - 1];
            if(val != t) return false;
        }

        for(int j = c; j < c + len; j ++) {
            int val = r == 0? cols[r + len - 1][j]: cols[r + len - 1][j] - cols[r - 1][j];
            if(val != t) return false;
        }

        int val = r > 0 && c > 0? diag[r + len - 1][c + len - 1] - diag[r - 1][c - 1]: diag[r + len - 1][c + len - 1];
        if(t != val) return false;

        val = r > 0 && c + len < anti[0].length? anti[r + len - 1][c] - anti[r - 1][c + len]: anti[r + len - 1][c];
        if(t != val) return false;

        return true;
    }

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int min = Math.min(n, m);

        int[][] rows = new int[n][m];
        int[][] cols = new int[n][m];
        int[][] diag = new int[n][m];
        int[][] anti = new int[n][m];

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                rows[i][j] = cols[i][j] = diag[i][j] = anti[i][j] = grid[i][j];
                if(j > 0) rows[i][j] += rows[i][j-1];
                if(i > 0) cols[i][j] += cols[i-1][j];
                if(i > 0 && j > 0) diag[i][j] += diag[i-1][j-1];
                if(i > 0 && j < m - 1) anti[i][j] += anti[i-1][j+1];
            }
        }

        for(int len = min; len >= 1; len --) {
            for(int i = 0; i <= n - len; i ++) {
                for(int j = 0; j <= m - len; j ++) {
                    if(check(i, j, len, rows, cols, diag, anti)) return len;
                }
            }
        }

        return 1;
    }
}