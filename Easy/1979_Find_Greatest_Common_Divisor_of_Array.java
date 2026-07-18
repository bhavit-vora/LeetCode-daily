/*
    TC: O(n)
    SC: O(1)
*/

class Solution {

    public int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];
        for(int i: nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return gcd(min, max);
    }
}