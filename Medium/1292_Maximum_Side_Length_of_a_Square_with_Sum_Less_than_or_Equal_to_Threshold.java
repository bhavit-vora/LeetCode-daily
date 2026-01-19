/*
    TC: O((n * m) + (n * m * min(n, m)))
    SC: O(n * m)
*/

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] pref = new int[n+1][m+1];

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                pref[i][j] = pref[i-1][j] + pref[i][j-1] + mat[i-1][j-1] - pref[i-1][j-1];
            }
        }

        for(int len = Math.min(n, m); len > 0; len --) {
            for(int i = 0; i <= n - len; i ++) {
                for(int j = 0; j <= m - len; j ++) {
                    int r = i + len;
                    int c = j + len;

                    int val = pref[r][c] + pref[i][j] - pref[i][c] - pref[r][j];
                    if(val <= threshold) return len;
                }
            }
        }

        return 0;
    }
}