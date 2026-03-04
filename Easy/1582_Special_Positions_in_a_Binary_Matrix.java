/*
    TC: O(n * m)
    SC: O(n + m)
*/

class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for(int i = 0; i < n; ++ i) {
            for(int j = 0; j < m; ++ j) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; ++ i) {
            for(int j = 0; j < m; ++ j) {
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}