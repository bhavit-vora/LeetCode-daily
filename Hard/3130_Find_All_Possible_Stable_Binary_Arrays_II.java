/*
    TC: O(zero * one)
    SC: O(zero * one)
*/

class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int mod = 1_000_000_007;
        int[][][] dp = new int[zero + 1][one + 1][2];

        for(int i = 0; i <= Math.min(zero, limit); ++ i) dp[i][0][0] = 1;
        for(int j = 0; j <= Math.min(one, limit); ++ j) dp[0][j][1] = 1;

        for(int i = 1; i <= zero; ++ i) {
            for(int j = 1; j <= one; ++ j) {
                dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % mod;
                if(j-1 >= limit) dp[i][j][1] = (dp[i][j][1] - dp[i][j-1-limit][0] + mod) % mod;
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % mod;
                if(i-1 >= limit) dp[i][j][0] = (dp[i][j][0] - dp[i-1-limit][j][1] + mod) % mod;
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }
}