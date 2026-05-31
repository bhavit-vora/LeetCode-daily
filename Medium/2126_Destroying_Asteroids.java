/*
    TC: O(n * logn)
    SC: O(1)
*/

import java.util.*;

class Solution {
    public boolean asteroidsDestroyed(long mass, int[] ast) {
        Arrays.sort(ast);

        for(int i: ast) {
            if(mass < i) return false;
            mass += i;
        }

        return true;
    }
}