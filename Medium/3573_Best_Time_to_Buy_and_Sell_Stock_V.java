/*
    TC: O(n * k)
    SC: O(n * k)
*/

class Solution {
    int n;

    // memoization
    public long helper(int[] nums, int i, int k, int type, long[][][] dp) {
        if(i == n) {
            if(type == 2) return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[i][k][type] != -1) return dp[i][k][type];

        long skip = helper(nums, i+1, k, type, dp);
        long take = 0;
        if(k > 0) {
            if(type == 0) {
                take = nums[i] + helper(nums, i+1, k-1, 2, dp);
            } else if(type == 1) {
                take = -nums[i] + helper(nums, i+1, k-1, 2, dp);
            } else {
                take = Math.max(-nums[i] + helper(nums, i+1, k, 0, dp),
                                 nums[i] + helper(nums, i+1, k, 1, dp));
            }
        }

        return dp[i][k][type] = Math.max(take, skip);
    }

    public long maximumProfit(int[] prices, int k) {
        n = prices.length;
        long[][][] dp = new long[n+1][k+1][3];
        // for(long[][] i: dp) for(long[] j: i) Arrays.fill(j, -1); //for memoization

        //tabulation
        for(int i = 0; i <= k; i ++) {
            dp[n][i][0] = dp[n][i][1] = Integer.MIN_VALUE;
        }

        for(int i = n-1; i >= 0; i --) {
            for(int j = 1; j <= k; j ++) {
                dp[i][j][0] = Math.max(dp[i+1][j][0], prices[i] + dp[i+1][j-1][2]);
                dp[i][j][1] = Math.max(dp[i+1][j][1], -prices[i] + dp[i+1][j-1][2]);
                dp[i][j][2] = Math.max(dp[i+1][j][2], Math.max(-prices[i] + dp[i+1][j][0], prices[i] + dp[i+1][j][1]));
            }
        }

        return dp[0][k][2];
    }
}