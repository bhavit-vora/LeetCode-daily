/*
    TC: O(4 * n)
    SC: O(2 * n)
*/

import java.util.*;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i: hBars) set1.add(i);
        for(int i: vBars) set2.add(i);

        int chain1 = 0;
        for(int i: set1) {
            if(!set1.contains(i-1)) {
                int c = 0;
                while(set1.contains(i+c)) c++;
                chain1 = Math.max(chain1, c+1);
            }
        }
        
        int chain2 = 0;
        for(int i: set2) {
            if(!set2.contains(i-1)) {
                int c = 0;
                while(set2.contains(i+c)) c++;
                chain2 = Math.max(chain2, c+1);
            }
        }

        int longest = Math.min(chain1, chain2);

        return longest * longest;

    }
}