/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x > 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }

        return ans;
    }

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int min = n + 10;

        for(int i = 0; i < n; ++ i) {
            int x = reverse(nums[i]);
            if(map.containsKey(nums[i])) min = Math.min(min, i - map.get(nums[i]));
            map.put(x, i);
        }

        return min == n + 10? -1: min;
    }
}