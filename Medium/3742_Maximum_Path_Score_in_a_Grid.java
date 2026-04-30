/*
    TC: O(n * m * k)
    SC: O(n * m * k)
*/

import java.util.*;

class Solution {
    int m;
    int n;
    int[][][] dp;
    
    public int scoreMin(int[][] grid, int k, int i, int j, int cost) {
        if(i == m || j == n) return Integer.MIN_VALUE;

        int c = grid[i][j] == 0? 0: 1;
        c += cost;
        if(c > k) return Integer.MIN_VALUE;

        if(i == m-1 && j == n-1) return grid[i][j];
        
        if(dp[i][j][c] != -1) return dp[i][j][c];
        int x = scoreMin(grid, k, i+1, j, c);
        int y = scoreMin(grid, k, i, j+1, c);

        int s = Math.max(x, y);

        if(s == Integer.MIN_VALUE) {
            return dp[i][j][c] = s;
        }

        return dp[i][j][c] = s + grid[i][j];
        
    }
    
    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][k+100];

        for(int[][] i: dp) {
            for(int[] j: i) {
                Arrays.fill(j, -1);
            }
        }

        int score = scoreMin(grid, k, 0, 0, 0);

        return score == Integer.MIN_VALUE? -1: score;
        
    }
}