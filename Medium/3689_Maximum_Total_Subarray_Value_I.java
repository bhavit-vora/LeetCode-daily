/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = 0, min = nums[0];

        for(int i: nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        return 1l * k * (max - min);
    }
}