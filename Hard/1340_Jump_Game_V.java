/*
    TC: O(n * d)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int[][] nums = new int[n][2];
        for(int i = 0; i < n; ++ i) {
            nums[i][0] = i;
            nums[i][1] = arr[i];
        }

        int max = 0;
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);

        for(int i = 0; i < n; ++ i) {
            int cur = nums[i][1];
            int idx = nums[i][0];
            dp[idx] = 1;

            for(int j = idx - 1; j >= 0 && idx - j <= d && arr[j] < cur; -- j) {
                if(dp[j] != -1) dp[idx] = Math.max(dp[idx], 1 + dp[j]);
            }

            for(int j = idx + 1; j < n && j - idx <= d && arr[j] < cur; ++ j) {
                if(dp[j] != -1) dp[idx] = Math.max(dp[idx], 1 + dp[j]);
            }

            max = Math.max(max, dp[idx]);
        }

        return max;
    }
}