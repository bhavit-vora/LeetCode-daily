/*
    TC: O(n * logn)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i ++) {
            if(arr[i] - arr[i-1] < min) {
                min = arr[i] - arr[i-1];
                ans = new ArrayList<>();
            } if(arr[i] - arr[i-1] == min) {
                List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i-1], arr[i]));
                ans.add(temp);
            }
        }

        return ans;
    }
}