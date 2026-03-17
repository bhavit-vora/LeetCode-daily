/*
    TC: O(n * m * logm)
    SC: O(m)
*/

import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prefs = new int[m];
        int ans = 0;

        for(int i = 0; i < n; ++ i) {
            for(int j = 0; j < m; ++ j) {
                if(matrix[i][j] == 1) prefs[j]++;
                else prefs[j] = 0;
            }

            int temp = 0;
            int[] arr = Arrays.copyOf(prefs, m);
            Arrays.sort(arr);

            int idx = m - 1;
            while(idx >= 0 && arr[idx] > 0) {
                temp = Math.max(temp, arr[idx] * (m - idx));
                idx--;
            }

            ans = Math.max(ans, temp);
        }

        return ans;
    }
}