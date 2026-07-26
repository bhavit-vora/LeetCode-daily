/*
    TC: O(n * logn)
    SC: O(1)
*/

import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        if(nums[nums.length-1] < 0) return nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];

        return nums[nums.length-1] * Math.max(nums[nums.length-2] * nums[nums.length-3], nums[0] * nums[1]);
    }
}