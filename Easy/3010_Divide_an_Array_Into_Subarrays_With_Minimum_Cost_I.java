/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int minimumCost(int[] nums) {
        int min1 = Math.min(nums[1], nums[2]), min2 = Math.max(nums[1], nums[2]);
        for(int i = 3; i < nums.length; i ++) {
            if(nums[i] <= min1) {
                min2 = Math.min(min1, min2);
                min1 = nums[i];
            } else {
                min2 = Math.min(min2, nums[i]);
            }
        }

        return nums[0] + min1 + min2;
    }
}
