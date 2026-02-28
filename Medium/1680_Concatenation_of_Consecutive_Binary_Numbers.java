/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        for(int i = 1; i <= n; i ++) {
            int cnt = 32 - Integer.numberOfLeadingZeros(i);
            ans <<= cnt;
            ans |= i;
            ans %= 1_000_000_007;
        }

        return (int) ans;
    }
}