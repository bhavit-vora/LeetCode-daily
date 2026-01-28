/*
    TC: O(k * n * m)
    SC: O(n * m)
*/

import java.util.*;

class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] cost = new int[n][m];
        for(int[] i: cost) Arrays.fill(i, Integer.MAX_VALUE);

        int[][] cell = new int[m*n][2];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                cell[i*m + j][0] = i;
                cell[i*m + j][1] = j;
            }
        }

        Arrays.sort(cell, (a, b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]));

        for(int t = 0; t <= k; t ++) {

            int min = Integer.MAX_VALUE;
            int start = 0;
            for(int i = 0; i < n * m; i ++) {
                int x = cell[i][0];
                int y = cell[i][1];
                min = Math.min(min, cost[x][y]);

                if(i+1 < n * m && grid[x][y] == grid[cell[i+1][0]][cell[i+1][1]]) continue;

                for(int j = start; j <= i; j ++) {
                    cost[cell[j][0]][cell[j][1]] = min;
                }

                start = i+1;
            }

            for(int i = n-1; i >= 0; i --) {
                for(int j = m-1; j >= 0 ; j --) {
                    if(i == n-1 && j == m-1) cost[i][j] = 0;
                    
                    if(i < n-1) {
                        cost[i][j] = Math.min(cost[i][j], grid[i+1][j] + cost[i+1][j]);
                    }

                    if(j < m-1) {
                        cost[i][j] = Math.min(cost[i][j], grid[i][j+1] + cost[i][j+1]);
                    }
                }
            }
        }

        return cost[0][0];
    }
}