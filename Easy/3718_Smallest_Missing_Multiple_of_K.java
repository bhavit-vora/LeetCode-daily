/*
    TC: O(n)
    SC: O(n * k)
*/

class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;

        int[] freq = new int[n * k + k + 1];
        for(int i: nums) if(i < n * k + k + 1) freq[i]++;

        for(int i = k; i < n * k + k + 1; i += k) if(freq[i] == 0) return i;
        return -1;
    }
}