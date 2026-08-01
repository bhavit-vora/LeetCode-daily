/*
    TC: O(n ^ 2)
    SC: O(n ^ 2)
*/

class Solution {

    Integer[][] dp;

    public int helper(int player, int[] nums, int l, int r) {
        if(l > r) return 0;
        if(dp[l][r] != null) return dp[l][r];

        if(player == 0) {
            return dp[l][r] = Math.max(nums[l] + helper(1 - player, nums, l + 1, r), nums[r] + helper(1 - player, nums, l, r - 1));
        } else {
            return dp[l][r] = Math.min(-nums[l] + helper(1 - player, nums, l + 1, r), -nums[r] + helper(1 - player, nums, l, r - 1));
        }
    }

    public boolean predictTheWinner(int[] nums) {
        dp = new Integer[nums.length][nums.length];
        return helper(0, nums, 0, nums.length - 1) >= 0;
    }
}