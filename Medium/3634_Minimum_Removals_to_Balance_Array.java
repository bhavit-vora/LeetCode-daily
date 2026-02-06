/*
    TC: O(n * logn)
    SC: O(1)
*/

import java.util.*;

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int max = 0;
        int l = 0, r = 0;
        while(r < n) {
            while(r < n && 1l * nums[l] * k >= nums[r]) r++;
            max = Math.max(max, r - l);
            l++;
        }

        return n - max;
    }
}