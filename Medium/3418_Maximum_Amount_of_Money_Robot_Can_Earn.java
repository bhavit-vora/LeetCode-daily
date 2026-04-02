/*
    TC: O(m * n)
    SC: O(m * n)
*/

import java.util.*;

class Solution {
    int m, n;
    int[][][] dp;

    public int helper(int[][] coins, int i, int j, int used) {
        if(i == m - 1 && j == n - 1) {
            if(coins[i][j] >= 0) return coins[i][j];
            else if(used < 2) return 0;
            return coins[i][j];
        }

        if(i == m || j == n) return Integer.MIN_VALUE / 4;
        if(dp[i][j][used] != -100000000) return dp[i][j][used];

        int down, right;
        int max = Integer.MIN_VALUE / 2;
        if(used < 2) {
            max = Math.max(max, Math.max(0, coins[i][j]));
            down = helper(coins, i + 1, j, used + 1);
            right = helper(coins, i, j + 1, used + 1);
            max += Math.max(right, down);
        }
        
        down = helper(coins, i + 1, j, used);
        right = helper(coins, i, j + 1, used);
        max = Math.max(max, coins[i][j] + Math.max(down, right));

        return dp[i][j][used] = max;
    }

    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        dp = new int[m][n][3];
        for(int[][] i: dp) for(int[] j: i) Arrays.fill(j, -100000000);
        return helper(coins, 0, 0, 0);
    }
}