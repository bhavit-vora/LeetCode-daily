/*
    TC: O(e * log v)
    SC: O(v + e)
*/

import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i ++) {
            graph.add(new ArrayList<>());
        }

        for(int[] i: edges) {
            graph.get(i[0]).add(new int[]{i[1], i[2]});
            graph.get(i[1]).add(new int[]{i[0], 2 * i[2]});
        }

        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if(cur[0] == n-1) return cur[1];

            if(vis[cur[0]]) continue;
            vis[cur[0]] = true;

            for(int[] i: graph.get(cur[0])) {
                if(!vis[i[0]]) {
                    pq.offer(new int[]{i[0], i[1] + cur[1]});
                }
            }
        }

        return -1;
    }
}