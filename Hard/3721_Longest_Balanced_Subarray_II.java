/*
    TC: O(n * logn)
    SC: O(n)
*/

import java.util.*;

class Solution {
    int n;
    int[] minSegTree;
    int[] maxSegTree;
    int[] lazySegTree;

    public void update(int s, int e, int i, int l, int r, int val) {
        propagate(i, l, r);

        if(l > e || r < s) return;
        if(l >= s && r <= e) {
            lazySegTree[i] += val;
            propagate(i, l, r);
            return;
        }

        int mid = (l + r) / 2;
        update(s, e, 2 * i + 1, l, mid, val);
        update(s, e, 2 * i + 2, mid + 1, r, val);

        minSegTree[i] = Math.min(minSegTree[2 * i + 1], minSegTree[2 * i + 2]);
        maxSegTree[i] = Math.max(maxSegTree[2 * i + 1], maxSegTree[2 * i + 2]);
    }

    public void propagate(int i, int l, int r) {
        if(lazySegTree[i] == 0) return;

        minSegTree[i] += lazySegTree[i];
        maxSegTree[i] += lazySegTree[i];
      
        if(l != r) {
            lazySegTree[2 * i + 1] += lazySegTree[i];
            lazySegTree[2 * i + 2] += lazySegTree[i];
        }

        lazySegTree[i] = 0;
    }

    public int findLeftmostZero(int i, int l, int r) {
        propagate(i, l, r);

        if(minSegTree[i] > 0 || maxSegTree[i] < 0) return -1;

        if(l == r) return l;

        int mid = (l + r) / 2;
        int left = findLeftmostZero(2 * i + 1, l, mid);
        if(left != -1) return left;
        return findLeftmostZero(2 * i + 2, mid + 1, r);
    }

    public int longestBalanced(int[] nums) {
        int max = 0;
        n = nums.length;

        minSegTree = new int[4 * n];
        maxSegTree = new int[4 * n];
        lazySegTree = new int[4 * n];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i ++) {
            int val = nums[i] % 2 == 0? 1: -1;

            int prev = -1;
            if(map.containsKey(nums[i])) {
                prev = map.get(nums[i]);
            }

            if(prev != -1) {
                update(0, prev, 0, 0, n-1, -val);
            }

            update(0, i, 0, 0, n-1, val);
            int l = findLeftmostZero(0, 0, n-1);
            if(l != -1) max = Math.max(max, i - l + 1);

            map.put(nums[i], i);

        }

        return max;
    }
}