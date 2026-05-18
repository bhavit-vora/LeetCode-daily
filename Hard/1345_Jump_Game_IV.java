/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; ++ i) map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = true;

        int ans = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; ++ i) {
                int cur = q.poll();
                if(cur == n - 1) return ans;

                if(cur - 1 >= 0 && !vis[cur - 1]) {
                    vis[cur - 1] = true;
                    q.offer(cur - 1);
                } if(cur + 1 < n && !vis[cur + 1]) {
                    vis[cur + 1] = true;
                    q.offer(cur + 1);
                }

                if(!map.containsKey(arr[cur])) continue;

                for(int ii: map.get(arr[cur])) {
                    if(!vis[ii]) {
                        vis[ii] = true;
                        q.offer(ii);
                    }
                }

                map.remove(arr[cur]);
            }

            ans++;
        }

        return -1;
    }
}