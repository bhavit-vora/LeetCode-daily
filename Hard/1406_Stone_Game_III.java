/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    Integer[] dp;

    public int helper(int idx, int[] stone) {
        int n = stone.length;
        if(idx >= n) return 0;
        if(dp[idx] != null) return dp[idx];

        int sum = 0;
        int maxDiff = Integer.MIN_VALUE;

        for (int k = 0; k < 3 && idx + k < n; k++) {
            sum += stone[idx + k];
            maxDiff = Math.max(maxDiff, sum - helper(idx + k + 1, stone));
        }

        return dp[idx] = maxDiff;
    }

    public String stoneGameIII(int[] stone) {
        int n = stone.length;
        
        dp = new Integer[n];
        int ans = helper(0, stone);

        if(ans > 0) return "Alice";
        else if(ans < 0) return "Bob";
        return "Tie";
    }
}