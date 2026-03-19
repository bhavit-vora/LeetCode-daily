/*
    TC: O(n * m)
    SC: O(n * m)
*/

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] pref = new int[n][m][2];
        if(grid[0][0] == 'X') pref[0][0][0] = 1;
        else if(grid[0][0] == 'Y') pref[0][0][1] = 1;

        int cnt = 0;

        for(int i = 1; i < n; ++ i) {
            pref[i][0][0] = pref[i-1][0][0];
            pref[i][0][1] = pref[i-1][0][1];
            if(grid[i][0] == 'X') pref[i][0][0]++;
            if(grid[i][0] == 'Y') pref[i][0][1]++;
            if(pref[i][0][0] != 0 && pref[i][0][0] == pref[i][0][1]) cnt++;
        }

        for(int j = 1; j < m; ++ j) {
            pref[0][j][0] = pref[0][j-1][0];
            pref[0][j][1] = pref[0][j-1][1];
            if(grid[0][j] == 'X') pref[0][j][0]++;
            if(grid[0][j] == 'Y') pref[0][j][1]++;
            if(pref[0][j][0] != 0 && pref[0][j][0] == pref[0][j][1]) cnt++;
        }

        for(int i = 1; i < n; ++ i) {
            for(int j = 1; j < m; ++ j) {
                pref[i][j][0] = pref[i-1][j][0] + pref[i][j-1][0] - pref[i-1][j-1][0];
                pref[i][j][1] = pref[i-1][j][1] + pref[i][j-1][1] - pref[i-1][j-1][1];
                if(grid[i][j] == 'X') pref[i][j][0]++;
                if(grid[i][j] == 'Y') pref[i][j][1]++;
                if(pref[i][j][0] != 0 && pref[i][j][0] == pref[i][j][1]) cnt++;
            }
        }

        return cnt;
    }
}