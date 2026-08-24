/*
    TC: O(n)
    SC: O(n)
*/

class Solution {

    // memoization
    public int helper(int[] stones, int i, Integer[] dp) {
        if(i == stones.length - 1) return stones[stones.length - 1];
        if(dp[i] != null) return dp[i];

        int take = stones[i] - helper(stones, i + 1, dp);
        int skip = helper(stones, i + 1, dp);

        return dp[i] = Math.max(take, skip);
    }

    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        for(int i = 1; i < n; ++ i) stones[i] += stones[i - 1];

        int[] dp = new int[n];
        dp[n - 1] = stones[n - 1];

        // tabulation
        for(int i = n - 2; i >= 1; -- i) {
            int take = stones[i] - dp[i + 1];
            int skip = dp[i + 1];
            dp[i] = Math.max(take, skip);
        }

        return dp[1];
    }
}