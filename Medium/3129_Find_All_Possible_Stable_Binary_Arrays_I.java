/*
    TC: O(zero * one * limit)
    SC: O(zero * one)
*/

class Solution {

    int mod = 1_000_000_007;
    int[][][] dp;

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new int[zero+1][one+1][2];

        for(int z = 0; z <= zero; ++ z) {
            for(int o = 0; o <= one; ++ o) {
                if(z > 0) {
                    for(int k = 1; k <= limit && k <= z; ++ k) {
                        if(z-k == 0 && o == 0) dp[z][o][0] = (dp[z][o][0] + 1) % mod;
                        else dp[z][o][0] = (dp[z][o][0] + dp[z-k][o][1]) % mod;
                    }
                } if(o > 0) {
                    for(int k = 1; k <= limit && k <= o; ++ k) {
                        if(o-k == 0 && z == 0) dp[z][o][1] = (dp[z][o][1] + 1) % mod;
                        else dp[z][o][1] = (dp[z][o][1] + dp[z][o-k][0]) % mod;
                    }                
                }
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }
}