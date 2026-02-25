/*
    TC: O(n * logn)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        int[][] bit = new int[n][2];
        for(int i = 0; i < n; i ++) {
            bit[i][0] = arr[i];
            bit[i][1] = Integer.bitCount(arr[i]);
        }

        Arrays.sort(bit, (a, b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        for(int i = 0; i < n; i ++) ans[i] = bit[i][0];
        
        return ans;
    }
}