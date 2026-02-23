/*
    TC: O(n)
    SC: O(2 ^ k)
*/

import java.util.*;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<Integer> set = new HashSet<>();

        int hash = 0;
        for(int i = 0; i < n; i ++) {
            hash <<= 1;
            hash |= (s.charAt(i) == '1'? 1: 0);
            hash &= ~(1 << k);
            if(i+1 >= k) set.add(hash);
        }

        return set.size() == Math.pow(2, k);
    }
}