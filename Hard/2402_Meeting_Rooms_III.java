/*
    TC: O(m * (logm + logn))
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];

        // arrayOf(endTime, roomNo)
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        for(int i = 0; i < n; i ++) pq.offer(new long[]{0l, i});
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int max = 0;
        int room = -1;

        for(int i = 0; i < meetings.length; i ++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            int duration = end - start;

            List<Integer> free = new ArrayList<>();
            while(!pq.isEmpty() && pq.peek()[0] <= start) {
                long[] curr = pq.poll();
                int r = (int)curr[1];
                free.add(r);
            }

            for(int r: free) pq.offer(new long[]{0l, r});

            long[] curr = pq.poll();

            int roomNo = (int)curr[1];
            count[roomNo]++;
            if(count[roomNo] > max) {
                max = count[roomNo];
                room = roomNo;
            } else if(count[roomNo] == max && roomNo < room) {
                room = roomNo;
            }
            
            long newTime = Math.max(curr[0], start) + duration;
            pq.offer(new long[]{newTime, curr[1]});
        }

        return room;
    }
}