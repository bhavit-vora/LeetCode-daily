/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {

    int ans = Integer.MAX_VALUE;

    public void dfs(int node, List<List<int[]>> graph, boolean[] vis) {
        vis[node] = true;

        for (int[] e : graph.get(node)) {
            ans = Math.min(ans, e[1]);

            if (!vis[e[0]]) {
                dfs(e[0], graph, vis);
            }
        }
    }

    public int minScore(int n, int[][] roads) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] r : roads) {
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }

        boolean[] vis = new boolean[n + 1];
        dfs(1, graph, vis);

        return ans;
    }
}