/*
    TC: O(n)
    SC: O(1)
*/

import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int[] freq = new int[101];
        int max = nums[0], min = nums[0];
        for(int i: nums) {
            freq[i]++;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = min; i <= max; ++ i) if(freq[i] == 0) ans.add(i);
        return ans;
    }
}