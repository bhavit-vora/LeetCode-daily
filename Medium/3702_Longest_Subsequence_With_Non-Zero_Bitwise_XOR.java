/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int longestSubsequence(int[] nums) {
        int zero = 0, xor = 0;
        for(int i: nums) {
            if(i == 0) zero++;
            else xor ^= i;
        }

        if(xor > 0) return nums.length;
        if(zero == nums.length) return 0;
        return nums.length - 1;
    }
}