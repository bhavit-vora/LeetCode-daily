/*
    TC: O(n * logn)
    SC: O(n)
*/

import java.util.*;;

record Pair(long x, int i) implements Comparable<Pair> {
    @Override
    public int compareTo(Pair o) {
        int c = Long.compare(this.x(), o.x());
        if (c != 0) return c;
        return Integer.compare(this.i(), o.i());
    }
}

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        TreeSet<Pair> set = new TreeSet<>();

        int[] prev = new int[n];
        int[] next = new int[n];
        long[] arr = new long[n];

        for(int i = 0; i < n; i ++) {
            prev[i] = i-1;
            next[i] = i+1;
            arr[i] = nums[i];
        }

        int badPairs = 0;
        for(int i = 0; i < n-1; i ++) {
            if(nums[i+1] < nums[i]) badPairs++;
            set.add(new Pair(nums[i] + nums[i+1], i));
        }

        int cnt = 0;
        while(badPairs != 0) {
            Pair curr = set.pollFirst();
            int first = curr.i();
            int second = next[first];

            int first_left = prev[first];
            int second_right = next[second];

            long sum = arr[first] + arr[second];

            if(arr[first] > arr[second]) badPairs--;

            if(first_left >= 0) {
                if(arr[first_left] > arr[first] && arr[first_left] <= sum) badPairs--;
                if(arr[first_left] <= arr[first] && arr[first_left] > sum) badPairs++;
                set.remove(new Pair(arr[first_left] + arr[first], first_left));
                set.add(new Pair(arr[first_left] + sum, first_left));
            }

            if(second_right < n) {
                if(arr[second_right] >= arr[second] && arr[second_right] < sum) badPairs++;
                if(arr[second_right] < arr[second] && arr[second_right] >= sum) badPairs--;
                set.remove(new Pair(arr[second_right] + arr[second], second));
                set.add(new Pair(arr[second_right] + sum, first));
                prev[second_right] = first;
            }

            next[first] = second_right;
            arr[first] += arr[second];
            cnt++;

        }

        return cnt;
    }
}