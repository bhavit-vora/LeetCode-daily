/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prev = 0;
        
        int i = 0;
        while(i < s.length()) {
            int c = 0;
            char ch = s.charAt(i);
            
            while(i < s.length() && s.charAt(i) == ch) {
                i++;
                c++;
            }

            ans += Math.min(c, prev);
            prev = c;
        }
        
        return ans;
    }
}