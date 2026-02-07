/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int a = 0;
        for(int i = 0; i < n; i ++) if(s.charAt(i) == 'a') a++;

        int b = 0, ans = n;
        for(int i = 0; i < n; i ++) {
            if(s.charAt(i) == 'a') a--;
            ans = Math.min(ans, a + b);
            if(s.charAt(i) == 'b') b++;
        }

        return ans;
    }
}