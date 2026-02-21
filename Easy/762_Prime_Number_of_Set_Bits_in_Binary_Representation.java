/*
    TC: O(10 ^ 6)
    SC: O(10 ^ 6)
*/

import java.util.*;

class Solution {
    public static Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
    public static int pref[] = new int[1000001];

    public int countPrimeSetBits(int left, int right) {
        if(!set.contains(37)) {
            set.add(37);
            for(int i = 1; i <= 1000000; i ++) {
                int bits = Integer.bitCount(i);
                if(set.contains(bits)) pref[i]++;
            }

            for(int i = 1; i <= 1000000; i ++) pref[i] += pref[i-1];
        }

        return pref[right] - pref[left-1];
    }
}