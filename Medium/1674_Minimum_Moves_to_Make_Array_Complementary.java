/*
    TC: O(n + limit)
    SC: O(limit)
*/

class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        int[] pref = new int[2 * limit + 2];

        for(int i = 0; i < n / 2; ++ i) {
            int a = Math.min(nums[i], nums[n - i - 1]);
            int b = Math.max(nums[i], nums[n - i - 1]);

            pref[2] += 2;
            pref[a + 1] -= 1;
            pref[a + b] -= 1;
            pref[a + b + 1] += 1;
            pref[b + limit + 1] += 1;

        }

        for(int i = 1; i < 2 * limit + 2; ++ i) pref[i] += pref[i-1];

        int min = pref[2];
        for(int i = 2; i < 2 * limit + 2; ++ i) min = Math.min(min, pref[i]);

        return min;
    }
}