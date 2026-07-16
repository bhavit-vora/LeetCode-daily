/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {

    public int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;

        int max = 0;
        int[] pref = new int[n];
        for(int i = 0; i < n; ++ i) {
            max = Math.max(max, nums[i]);
            pref[i] = gcd(max, nums[i]);
        }

        Arrays.sort(pref);

        long sum = 0;
        int l = 0, r = n - 1;
        while(l < r) {
            sum += gcd(pref[l++], pref[r--]);
        }

        return sum;
    }
}