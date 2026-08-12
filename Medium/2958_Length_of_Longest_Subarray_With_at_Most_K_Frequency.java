/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        for(int i = 0; i < n; ++ i) {
            int ele = nums[i];
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            while(map.get(ele) > k) {
                int lef = nums[l++];
                map.put(lef, map.get(lef) - 1);
            }

            ans = Math.max(ans, i - l + 1);
        }

        return ans;
    }
}