/*
    TC: O(2N)
    SC: O(1)
*/

class Solution {
    final int MOD = 1_000_000_007;

    public int numberOfWays(String s) {
        int n = s.length();
        int cnt = 0;
        for(int i = 0; i < n; i++) if(s.charAt(i) == 'S') cnt++;
        if(cnt % 2 != 0 || cnt == 0) return 0;
        
        long ans = 1;
        int i = 0;
        while(n > 0 && s.charAt(n-1) == 'P') n--;
        while(i < n) {
            if(s.charAt(i) == 'S') {
                i++;
                while(i < n && s.charAt(i) != 'S') i++;
                i++;
                cnt = 1;
                while(i < n && s.charAt(i) != 'S') {
                    cnt++;
                    i++;
                }

                ans = (ans * cnt) % MOD;
                i--;
            }
            i++;
        }

        return (int)ans;
    }
}