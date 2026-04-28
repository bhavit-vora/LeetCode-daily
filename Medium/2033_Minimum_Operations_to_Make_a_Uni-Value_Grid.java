/*
    TC: O(n * m)
    SC: O(n * m)
*/

import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        if(m == 1 && n == 1) return 0;

        int[] arr = new int[n * m];
        int idx = 0;
        for(int[] i: grid) for(int j: i) arr[idx++] = j;

        Arrays.sort(arr);

        int ans = 0;
        int f = (m * n) / 2;

        for(int i = 0; i < m * n; ++ i) {
            if((arr[i] - arr[f]) % x != 0) return -1;
            ans += (Math.abs(arr[i] - arr[f]) / x);
        }

        return ans;
    }
}