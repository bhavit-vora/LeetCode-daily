/*
    TC: O(n + 100000)
    SC: O(100000)
*/

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] cnt = new int[100001];
        for(int i: costs) cnt[i]++;

        int ans = 0;

        for(int i = 0; i < 100001; ++ i) {
            if(cnt[i] == 0) continue;
            int c = Math.min(coins / i, cnt[i]);
            coins -= c * i;
            ans += c;
        }

        return ans;
    }
}