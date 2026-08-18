/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if(k == n) {
            int max = 0;
            for(int i: nums) max = Math.max(max, i);
            return max;
        } else if(k == 1) {
            int[] freq = new int[51];
            for(int i: nums) freq[i]++;
            for(int i = 50; i >= 0; -- i) if(freq[i] == 1) return i;
            return -1;
        }

        int f = nums[0];
        int s = nums[n - 1];

        int c1 = 0, c2 = 0;

        for(int i: nums) {
            if(i == f) c1++;
            if(i == s) c2++;
        }

        if(c1 == 1 && c2 == 1) return Math.max(f, s);
        if(c1 == 1) return f;
        if(c2 == 1) return s;
        return -1;
    }
}