/*
    TC: O(row * col * 9)
    SC: O(3 * 3) ~ O(1)
*/

import java.util.*;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int cnt = 0;

        for(int i = 0; i < row - 2; i ++) {
            for(int j = 0; j < col - 2; j ++) {

                // for rows
                int x = grid[i][j] + grid[i][j+1] + grid[i][j+2];
                if(x != grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2]) continue;
                if(x != grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2]) continue;

                // for diagonals
                if(x != grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]) continue;
                if(x != grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2]) continue;

                // for columns
                if(x != grid[i][j] + grid[i+1][j] + grid[i+2][j]) continue;
                if(x != grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1]) continue;
                if(x != grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2]) continue;

                // to check if all numbers from 1-9 are present
                Set<Integer> st = new HashSet<>(); 
                for(int p = i; p < i + 3; p ++) {
                    for(int q = j; q < j + 3; q ++) {
                        if(grid[p][q] > 0 && grid[p][q] < 10) st.add(grid[p][q]);
                    }
                }

                if(st.size() < 9) continue;
                cnt++;
            }
        }

        return cnt;
    }
}