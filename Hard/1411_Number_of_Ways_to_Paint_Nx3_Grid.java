/*
    TC: O(36 * n)
    SC: O(12 * n)
*/

import java.util.*;

class Solution {

    public static final int MOD = 1_000_000_007;
    public int[][] dp;
    public String[] states = {"RYR", "RYG", "RGR", "RGY",
                              "GYG", "GYR", "GRY", "GRG",
                              "YGY", "YGR", "YRG", "YRY"};

    public int helper(int n, int prev) {
        if(n == 0) return 1;
        if(dp[n][prev] != -1) return dp[n][prev];

        int res = 0;
        for(int i = 0; i < 12; i ++) {
            boolean flag = true;

            for(int j = 0; j < 3; j ++) {
                if(states[i].charAt(j) == states[prev].charAt(j)) {
                    flag = false;
                }
            }

            if(flag) {
                res += helper(n-1, i);
                res = res % MOD;
            }
        }

        return dp[n][prev] = res;
    }

    public int numOfWays(int n) {
        int cnt = 0;
        dp = new int[n][12];
        for(int[] i: dp) Arrays.fill(i, -1);

        for(int i = 0; i < 12; i ++) {
            cnt += helper(n-1, i);
            cnt = cnt % MOD;
        }

        return cnt;
    }
}