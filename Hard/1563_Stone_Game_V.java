/*
    TC: O(n ^ 2)
    SC: O(n ^ 2)
*/

import java.util.*;

class Solution {
    int[] pref;
    int[][] dp;

    public int helper(int l, int r) {
        if(l >= r) return 0;
        if(dp[l][r] != -1) return dp[l][r];

        int max = 0;
        for(int i = l; i <= r; ++ i) {
            int left = pref[i] - pref[l - 1];
            int right = pref[r] - pref[i];
            if(left <= right) max = Math.max(max, left + helper(l, i));
            if(right <= left) max = Math.max(max, right + helper(i + 1, r));
        }

        return dp[l][r] = max;
    }

    public int stoneGameV(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][n + 1];
        for(int[] i: dp) Arrays.fill(i, -1);
        pref = new int[n + 1];
        for(int i = 1; i <= n; ++ i) pref[i] = pref[i - 1] + nums[i - 1];
        return helper(1, n);
    }
}