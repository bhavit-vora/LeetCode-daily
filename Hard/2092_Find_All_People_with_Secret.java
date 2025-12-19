/*
    TC: O((n + m) log n)
    SC: O(n + m)
*/

import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i ++) graph.add(new ArrayList<>());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(int[] i: meetings) {
            int u = i[0];
            int v = i[1];
            int time = i[2];

            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        int[] time = new int[n];
        Arrays.fill(time, 1_000_000);
        List<Integer> ans = new ArrayList<>();
        pq.offer(new int[]{firstPerson, 0});
        pq.offer(new int[]{0, 0});
        time[0] = time[firstPerson] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            if(curr[1] > time[curr[0]]) continue;

            for(int[] i: graph.get(curr[0])) {
                if(i[0] != curr[0]) {
                    if(i[1] >= curr[1] && i[1] < time[i[0]]) {  
                        time[i[0]] = i[1];  
                        pq.offer(new int[]{i[0], i[1]});
                    }
                }
            }
        }

        for(int i = 0; i < n; i ++) if(time[i] != 1_000_000) ans.add(i);

        return ans;
    }
}