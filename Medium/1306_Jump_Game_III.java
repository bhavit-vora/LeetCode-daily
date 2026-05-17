/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        vis[start] = true;
        q.offer(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(arr[cur] == 0) return true;

            if(cur - arr[cur] >= 0 && !vis[cur - arr[cur]]) {
                vis[cur - arr[cur]] = true;
                q.offer(cur - arr[cur]);
            } if(cur + arr[cur] < n && !vis[cur + arr[cur]]) {
                vis[cur + arr[cur]] = true;
                q.offer(cur + arr[cur]);
            }
        }

        return false;
    }
}