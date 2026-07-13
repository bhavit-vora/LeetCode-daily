/*
    TC: O(1)
    SC: O(1)
*/

import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 2; i < 10; ++ i) {
            int base = 0;
            int inc = 0;
            for(int j = 1; j <= i; ++ j) {
                base = base + (j * (int)Math.pow(10, i - j));
                inc = inc * 10 + 1;
            }

            for(int j = 1; j < 11 - i && base <= high; j++, base += inc) if(base >= low) ans.add(base);
        }

        return ans;
    }
}