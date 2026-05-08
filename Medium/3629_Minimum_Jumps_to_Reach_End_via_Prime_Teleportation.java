/*
    TC: O(M * log(logM) + n)
    SC: O(M + n)
*/

import java.util.*;

class Solution {

    static int[] primes = new int[1000001];

    public void sieve() {
        primes[0] = primes[1] = 1;

        for(int i = 2; i <= 1000000; ++ i) {
            if(primes[i] == 1) continue;
            for(long j = 1l * i * i; j <= 1000000; j += i) {
                primes[(int)j] = 1;
            }
        }
    }

    public int minJumps(int[] nums) {
        if(primes[32] == 0) sieve();

        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; ++ i) map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i); 

        boolean[] vis = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = true;
        Set<Integer> seen = new HashSet<>();

        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; ++ i) {
                int idx = q.poll();
                if(idx == n - 1) return ans;

                int val = nums[idx];
                if(idx - 1 >= 0 && !vis[idx - 1]) {
                    vis[idx - 1] = true;
                    q.offer(idx - 1);
                } if(idx + 1 <  n && !vis[idx + 1]) {
                    vis[idx + 1] = true;
                    q.offer(idx + 1);
                } if(primes[val] == 0 && !seen.contains(val)) {
                    seen.add(val);
                    for(int f = val; f <= 1000000; f += val) {
                        if(map.containsKey(f)) {
                            for(int j: map.get(f)) {
                                if(!vis[j]) {
                                    vis[j] = true;
                                    q.offer(j);
                                }
                            }
                        }
                    }
                }
            }
            
            ans++;
        }

        return -1;
    }
}