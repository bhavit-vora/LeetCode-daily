/*
    TC: O(n ^ 2)
    SC: O(n ^ 2)
*/

import java.util.*;

class Solution {
    int[][] dp;

    public int helper(int i, int j, int[] nums1, int[] nums2) {
        if(i == nums1.length || j == nums2.length) return -100000000;
        if(dp[i][j] != -1) return dp[i][j];

        int pick = nums1[i] * nums2[j] + Math.max(0, helper(i+1, j+1, nums1, nums2));

        int skip1 = helper(i+1, j, nums1, nums2);
        int skip2 = helper(i, j+1, nums1, nums2);

        return dp[i][j] = Math.max(pick, Math.max(skip1, skip2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length];
        for(int[] i: dp) Arrays.fill(i, -1);
        return helper(0, 0, nums1, nums2);
    }
}