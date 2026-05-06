/*
    TC: O(n * m)
    SC: O(n * m)
*/

import java.util.*;

class Solution {
    public char[][] rotateTheBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        char[][] ans = new char[n][m];
        for(char[] i: ans) Arrays.fill(i, '.');

        for(int i = 0; i < m; ++ i) {
            int b = n - 1, j = n - 1;
            while(j >= 0) {
                if(grid[i][j] == '#') {
                    ans[b--][m - i - 1] = '#';
                } else if(grid[i][j] == '*') {
                    b = j;
                    ans[b--][m - i - 1] = '*';
                }
                j--;
            }
        }

        return ans;
    }
}