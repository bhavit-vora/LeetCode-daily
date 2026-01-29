/*
    TC: O(26 ^ 3 + n)
    SC: O(26 ^ 2)
*/

import java.util.*;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;
        long[][] dist = new long[26][26];
        for(long[] i: dist) Arrays.fill(i, Integer.MAX_VALUE);

        List<List<long[]>> graph = new ArrayList<>();
        for(int i = 0; i < 26; i ++) graph.add(new ArrayList<>());
        for(int i = 0; i < m; i ++) {
            graph.get(original[i]-'a').add(new long[]{changed[i]-'a', cost[i]});
        }

        for(int i = 0; i < 26; i ++) {
            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
            dist[i][i] = 0;
            for(long[] node: graph.get(i)) {
                if(node[1] < dist[i][(int)node[0]]) {
                    dist[i][(int)node[0]] = node[1];
                    pq.offer(new long[]{node[0], node[1]});
                }
            }

            while(!pq.isEmpty()) {
                long[] cur = pq.poll();
                for(long[] node: graph.get((int)cur[0])) {
                    if(node[1] + cur[1] < dist[i][(int)node[0]]) {
                        dist[i][(int)node[0]] = node[1] + cur[1];
                        pq.offer(new long[]{node[0], cur[1] + node[1]});
                    }
                }
            }
        }

        long cst = 0L;
        for(int i = 0; i < n; i ++) {
            int s = source.charAt(i) - 'a';
            int d = target.charAt(i) - 'a';

            if(dist[s][d] == Integer.MAX_VALUE) return -1;
            cst += dist[s][d];
        }

        return cst;
    }
}