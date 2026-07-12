/*
    TC: O(n * logn)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < n; ++ i) pq.offer(new int[]{arr[i], i});

        int prev = Integer.MIN_VALUE, rank = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(prev != cur[0]) rank++;
            ans[cur[1]] = rank;
            prev = cur[0];
        }

        return ans;
    }
}