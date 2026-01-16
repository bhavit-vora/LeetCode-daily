/*
    TC: O(n^2 + m^2)
    SC: O(m^2)
*/

import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] h, int[] v) {
        Set<Integer> set = new HashSet<>();

        set.add(m-1);
        for(int i = 0; i < h.length; i ++) {
            set.add(h[i] - 1);
            set.add(m - h[i]);
        }

        for(int i = 0; i < h.length; i ++) {
            for(int j = i+1; j < h.length; j ++) {
                set.add(Math.abs(h[j] - h[i]));
            }
        }

        long ans = -1;

        if(set.contains(n-1)) ans = 1l * (n-1) * (n-1);
        for(int i = 0; i < v.length; i ++) {
            if(set.contains(v[i]-1)) {
                ans = Math.max(ans, 1l * (v[i]-1) * (v[i]-1));
            } if(set.contains(n-v[i])) {
                ans = Math.max(ans, 1l * (n-v[i]) * (n-v[i]));
            }
        }

        for(int i = 0; i < v.length; i ++) {
            for(int j = i+1; j < v.length; j ++) {
                if(set.contains(Math.abs(v[j] - v[i]))) {
                    ans = Math.max(ans, 1l * (v[j]-v[i]) * (v[j]-v[i]));
                }
            }
        }

        return (int)(ans % 1_000_000_007);
    }
}