/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; ++ i) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int min = 1000000;

        for(var e: map.entrySet()) {
            List<Integer> l = e.getValue();
            if(l.size() < 3) continue;

            for(int i = 1; i < l.size() - 1; ++ i) {
                min = Math.min(min, 2 * (l.get(i+1) - l.get(i-1)));
            }
        }

        return min == 1000000? -1: min;
    }
}