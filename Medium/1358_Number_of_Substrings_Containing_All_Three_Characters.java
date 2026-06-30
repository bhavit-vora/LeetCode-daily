/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int a = -1, b = -1, c = -1;

        for(int i = 0; i < s.length(); ++ i) {
            if(s.charAt(i) == 'a') a = i;
            else if(s.charAt(i) == 'b') b = i;
            else c = i;

            if(a == -1 || b == -1 || c == -1) continue;

            int idx = Math.min(a, Math.min(b, c));
            ans += idx + 1;
        }

        return ans;
    }
}