/*
    TC: O(n * logn)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int[] prefMax = new int[n+1];
        Arrays.sort(events, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for(int i = n - 1; i >= 0 ; i --) prefMax[i] = Math.max(prefMax[i+1], events[i][2]);

        int ans = 0;
        for(int i = 0; i < n; i ++) {
            ans = Math.max(ans, events[i][2]);
            int low = i + 1;
            int high = n-1;

            while(low <= high) {
                int mid = (low + high) / 2;
                if(events[mid][0] <= events[i][1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            ans = Math.max(ans, events[i][2] + prefMax[low]);
        }

        return ans;
    }
}