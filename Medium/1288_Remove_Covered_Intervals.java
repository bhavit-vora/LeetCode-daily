/*
    TC: O(n * logn)
    SC: O(1)
*/

import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int ans = n;
        int st = -1, en = -1;
        for(int i = 0; i < n; ++ i) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            
            if(st <= a && b <= en) ans--;
            else {
                st = a;
                en = b;
            }
        }

        return ans;
    }
}