/*
    TC: O(1)
    SC: O(1)
*/

class Solution {
    public int mirrorDistance(int n) {
        int rev = 0;
        int p = n;
        while(p > 0) {
            rev = (rev * 10) + p % 10;
            p /= 10;
        }

        return Math.abs(n - rev);
    }
}