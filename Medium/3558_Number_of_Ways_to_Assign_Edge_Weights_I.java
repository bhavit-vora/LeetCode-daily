/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= n+1; ++ i) tree.add(new ArrayList<>());

        for(int[] e: edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        int max = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n+2];
        q.offer(1);
        vis[1] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; ++ i) {
                int cur = q.poll();

                for(int nei: tree.get(cur)) {
                    if(!vis[nei]) {
                        q.offer(nei);
                        vis[nei] = true;
                    }
                }
            }

            max++;
        }

        int ans = 1;
        for(int i = 1; i < max - 1; ++ i) ans = (ans << 1) % 1_000_000_007;
        return ans;
    }
}