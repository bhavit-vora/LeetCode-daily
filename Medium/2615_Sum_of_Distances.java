/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; ++ i) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[n];
        long[] temp1 = new long[n];
        long[] temp2 = new long[n];

        for(var e: map.entrySet()) {
            List<Integer> list = e.getValue();
            if(list.size() == 1) continue;

            for(int i = 1; i < list.size(); ++ i) {
                int idx = list.get(i);
                int prev = list.get(i - 1);
                temp1[idx] = temp1[prev]  + 1l * i * (idx - prev);
            }

            for(int i = list.size() - 2; i >= 0; -- i) {
                int idx = list.get(i);
                int next = list.get(i + 1);
                temp2[idx] = temp2[next]  + 1l * (list.size() - i - 1) * (next - idx);
            }
        }

        for(int i = 0; i < n; ++ i) ans[i] = temp1[i] + temp2[i];

        return ans;
    }
}