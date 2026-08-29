/*
    TC: O(n * logn)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int[][] arr = new int[n][2];
        for(int i = 0; i < n; ++ i) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int i = 0;
        while(i < n) {
            int j = i;
            int prev = arr[j][0];
            List<Integer> idxs = new ArrayList<>();
            idxs.add(arr[j][1]);
            j++;

            while(j < n && arr[j][0] - prev <= limit) {
                idxs.add(arr[j][1]);
                prev = arr[j][0];
                j++;
            }

            Collections.sort(idxs);
            for(int idx: idxs) {
                nums[idx] = arr[i++][0];
            }
        }        

        return nums;
    }
}