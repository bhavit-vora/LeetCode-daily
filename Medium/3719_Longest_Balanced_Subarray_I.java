/*
    TC: O(n ^ 2)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length, max = 0;

        for(int i = 0; i < n; i ++) {
            Set<Integer> map1 = new HashSet<>();
            Set<Integer> map2 = new HashSet<>();
            for(int j = i; j < n; j ++) {
                if((nums[j] & 1) == 0) {
                    map1.add(nums[j]);
                } else {
                    map2.add(nums[j]);
                }

                if(map1.size() == map2.size()) max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }
}