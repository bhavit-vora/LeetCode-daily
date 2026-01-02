/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int i: nums) {
            if(st.contains(i)) return i;
            st.add(i);
        }
        return -1;
    }
}