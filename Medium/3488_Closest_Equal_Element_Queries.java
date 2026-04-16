/*
    TC: O(n * logn + q * logn)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; ++ i) {
            int val = nums[i];
            map.computeIfAbsent(val, k -> new TreeSet<>()).add(i);      
        }

        List<Integer> ans = new ArrayList<>();
        for(int i: queries) {
            TreeSet<Integer> set = map.get(nums[i]);
            Integer prev = set.lower(i);
            Integer next = set.higher(i);

            if(prev == null && next == null) {
                ans.add(-1);
            } else if(prev == null) {
                ans.add(Math.min(next - i, n - set.last() + i));
            } else if(next == null) {
                ans.add(Math.min(i - prev, n - i + set.first()));
            } else {
                ans.add(Math.min(next - i, i - prev));
            }
        }

        return ans;
    }
}