/*
    TC: O(nlog n + k)
    SC: O(n)
*/

import java.util.PriorityQueue;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int i: happiness) pq.offer(i);

        long ans = 0;
        int dec = 0;

        while(!pq.isEmpty() && k -- > 0 && pq.peek() - dec > 0) {
            ans += pq.poll() - dec++;
        }

        return ans;
    }
}