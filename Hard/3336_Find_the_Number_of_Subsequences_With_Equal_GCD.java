/*
    TC: O(n * 200 * 200)
    SC: O(n * 200 * 200)
*/

import java.util.*;

class Solution {
    int mod = 1_000_000_007;
    int[][][] dp;

    public int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public int helper(int i, int gcd1, int gcd2, int[] nums) {
        if(i == nums.length) {
            if(gcd1 == gcd2 && gcd1 != 0) return 1;
            return 0;
        }

        if(dp[i][gcd1][gcd2] != -1) return dp[i][gcd1][gcd2];

        int cnt = helper(i + 1, gcd1, gcd2, nums);
        cnt = (cnt + helper(i + 1, gcd(gcd1, nums[i]), gcd2, nums)) % mod;
        cnt = (cnt + helper(i + 1, gcd1, gcd(gcd2, nums[i]), nums)) % mod;
        
        return dp[i][gcd1][gcd2] = cnt;
    }

    public int subsequencePairCount(int[] nums) {
        dp = new int[nums.length][201][201];
        for(int[][] i: dp) for(int[] j: i) Arrays.fill(j, -1);
        return helper(0, 0, 0, nums);
    }
}