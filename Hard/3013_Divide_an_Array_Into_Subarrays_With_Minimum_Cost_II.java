/*
    TC: O(n * logk)
    SC: O(n)
*/

import java.util.*;

class Pair {
    int val;
    int idx;
    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if(a.val != b.val) return Integer.compare(a.val, b.val);
            return Integer.compare(a.idx, b.idx);
        });        
        
        TreeSet<Pair> rem = new TreeSet<>((a, b) -> {
            if(a.val != b.val) return Integer.compare(a.val, b.val);
            return Integer.compare(a.idx, b.idx);
        });        

        long ans = 1l * Integer.MAX_VALUE * 100000000;
        long temp = 0;

        int i = 1;
        while(i - dist < 1) {
            set.add(new Pair(nums[i], i));
            temp += nums[i];
            i++;

            if(set.size() > k-1) {
                Pair t = set.pollLast();
                rem.add(t);
                temp -= t.val;
            }
        }

        for(; i < n; i ++) {
            set.add(new Pair(nums[i], i));
            temp += nums[i];

            if(set.size() > k-1) {
                Pair t = set.pollLast();
                rem.add(t);
                temp -= t.val;
            }

            ans = Math.min(ans, temp);

            Pair remove = new Pair(nums[i-dist], i-dist);
            if(set.contains(remove)) {
                set.remove(remove);
                temp -= remove.val;

                if(!rem.isEmpty()) {
                    Pair t = rem.pollFirst();
                    set.add(t);
                    temp += t.val;
                }
            } else {
                rem.remove(remove);
            }
        }

        return nums[0] + ans;
    }
}