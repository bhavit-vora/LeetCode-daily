/*
    TC: O(n * logn)
    SC: O(1)
*/

import java.util.*;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int min = 0;

        int l = 0, r = nums.length-1;
        while(l < r) {
            min = Math.max(min, nums[l++] + nums[r--]);
        }

        return min;
    }
}