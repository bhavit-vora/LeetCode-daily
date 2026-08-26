/*
    TC: O(n ^ 2)
    SC: O(n)
*/

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int c = 0;
        String ans = "";

        int l = 0, r = 0;
        while(r < s.length()) {
            if(s.charAt(r) == '1') c++;

            while(c > k || (l < s.length() && s.charAt(l) == '0')) {
                if(s.charAt(l++) == '1') c--;
            }

            if(c == k) {
                if(ans.equals("")) ans = s.substring(l, r + 1);
                else if(ans.length() > r - l + 1) ans = s.substring(l, r + 1);
                else if(ans.length() == r - l + 1 && ans.compareTo(s.substring(l, r + 1)) > 0) ans = s.substring(l, r + 1);
            }

            r++;
        }

        return ans;
    }
}