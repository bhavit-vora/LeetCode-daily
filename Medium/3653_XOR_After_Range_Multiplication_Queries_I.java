/*
    TC: O(q * n)
    SC: O(n)
*/

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int mod = 1_000_000_007;

        long[] arr = new long[n];
        for(int i = 0; i < n; ++ i) arr[i] = nums[i];

        for(int[] q: queries) {
            int idx = q[0];
            while(idx <= q[1]) {
                arr[idx] = (arr[idx] * q[3]) % mod;
                idx += q[2];
            }
        }

        long xor = 0;
        for(long i: arr) xor ^= i;
        return (int)xor;
    }
}