/*
    TC: O(N)
    SC: O(1)
*/

class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int i = 0;

        while(i < prices.length) {
            int j = i + 1;
            while(j < prices.length && prices[j] + 1 == prices[j-1]) j++;
            int len = j - i;
            ans += (long)len * (len + 1) / 2;
            i = j;
        }
        return ans;
    }
}