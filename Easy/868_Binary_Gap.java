/*
    TC: O(32)
    SC: O(1)
*/

class Solution {
    public int binaryGap(int n) {
        int ans = 0;
        int prev = -1;
        int i = 0;

        while(n > 0) {
            int bit = n & 1;

            if(bit == 1) {
                if(prev == -1) prev = i;
                else ans = Math.max(ans, i - prev);

                prev = i;
            }

            i++;
            n >>= 1;
        }

        return ans;
    }
}