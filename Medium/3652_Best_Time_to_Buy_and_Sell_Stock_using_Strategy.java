/*
    TC: O(2 * n)
    SC: O(1)
*/

class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int len = k / 2;

        long sum = 0;
        for(int i = 0; i < n; i ++) sum += prices[i] * strategy[i];

        long max = sum;

        int l = 0;
        for(int r = 0; r < n; r ++) {
            if(r - l + 1 < k) {
                if(r - l < len) {
                    if(strategy[r] == 1) {
                        sum -= prices[r];
                    } else if(strategy[r] == -1) {
                        sum += prices[r];
                    }
                } else {
                    if(strategy[r] == -1) {
                        sum += prices[r] + prices[r];
                    } else if(strategy[r] == 0) {
                        sum += prices[r];
                    }
                }
            } else if(r - l + 1 == k) {
                if(strategy[r] == -1) sum += prices[r] + prices[r];
                else if(strategy[r] == 0) sum += prices[r];
                max = Math.max(max, sum);

                if(strategy[l] == 1) sum += prices[l];
                else if(strategy[l] == -1) sum -= prices[l];
                sum -= prices[l+len];
                l++;
            }
        }

        return max;
    }
}