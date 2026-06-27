/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i: nums) freq.put(i, freq.getOrDefault(i, 0) + 1);

        int ans = freq.getOrDefault(1, 0);
        freq.remove(1);
        if(ans % 2 == 0) ans--;

        for(int i: nums) {
            long cur = i; int len = 0;
            while(cur < Integer.MAX_VALUE && freq.containsKey((int)cur)) {
                len += 2;
                if(freq.get((int)cur) == 1) break;
                cur = cur * cur;
            }

            ans = Math.max(ans, len - 1);
        }

        return ans;
    }
}