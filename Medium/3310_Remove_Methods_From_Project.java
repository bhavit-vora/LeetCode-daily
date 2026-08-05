/*
    TC: O(m + n)
    SC: O(m + n)
    m -> inv.length
*/

import java.util.*;

class Solution {

    public void dfs(int node, int[] sus, List<List<Integer>> graph) {
        if(sus[node] == 1) return;

        sus[node] = 1;
        for(int i: graph.get(node)) {
            dfs(i, sus, graph);
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] inv) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; ++ i) graph.add(new ArrayList<>());
        for(int[] i: inv) {
            graph.get(i[0]).add(i[1]);
        }

        int[] sus = new int[n];
        dfs(k, sus, graph);

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; ++ i) if(sus[i] == 0) q.offer(i);

        List<Integer> ans = new ArrayList<>();

        boolean flag = true;
        for(int[] i: inv) {
            int u = i[0];
            int v = i[1];

            if(sus[u] == 0 && sus[v] == 1) {
                flag = false;
                break;
            }
        }

        if(!flag) {
            for(int i = 0; i < n; ++ i) ans.add(i);
            return ans;
        }

        for(int i = 0; i < n; ++ i) {
            if(sus[i] == 0) ans.add(i);
        }

        return ans;
    }
}