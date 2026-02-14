/*
    TC: O(r * c)
    SC: O(r * c)
*/

class Solution {
    public double champagneTower(int poured, int r, int c) {
        double[][] arr = new double[r + 1][c + 2];

        arr[0][0] = poured;
        for(int i = 1; i <= r; i ++) {
            for(int j = 0; j < c + 2; j ++) {
                if(j == 0) arr[i][j] = Math.max(0, (arr[i-1][j] - 1) / 2);
                else if(j == i) arr[i][j] = Math.max(0, (arr[i-1][j-1] - 1) / 2);
                else arr[i][j] = Math.max(0, (arr[i-1][j] -1) / 2) + Math.max(0, (arr[i-1][j-1] - 1) / 2);
            }
        }

        return Math.min(1, arr[r][c]);
    }
}