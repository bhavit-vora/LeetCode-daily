/*
    TC: O(n + len(swaps) * a) a -> union(a, b)
    SC: O(n)
*/

import java.util.*;

class Solution {

    int n;
    int[] size;
    int[] parent;

    public int find(int node) {
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int u, int v) {
        int paru = find(u);
        int parv = find(v);

        if(paru == parv) return;

        if(size[paru] > size[parv]) {
            parent[parv] = paru;
            size[paru] += size[parv];
        } else {
            parent[paru] = parv;
            size[parv] += size[paru];
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] swaps) {
        n = source.length;
        size = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; ++ i) {
            size[i] = 1;
            parent[i] = i;
        }

        int ans = 0;

        for(int[] s: swaps) {
            union(s[0], s[1]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; ++ i) {
            int par = find(i);
            map.computeIfAbsent(par, k -> new ArrayList<>()).add(i);
        }

        for(var e: map.entrySet()) {
            Map<Integer, Integer> temp = new HashMap<>();
            for(int i: e.getValue()) {
                int s = source[i], d = target[i];
                temp.put(s, temp.getOrDefault(s, 0) + 1);
                temp.put(d, temp.getOrDefault(d, 0) - 1);
            }

            for(var i: temp.entrySet()) {
                ans += Math.abs(i.getValue());
            }           
        }

        return ans >> 1;
    }
}