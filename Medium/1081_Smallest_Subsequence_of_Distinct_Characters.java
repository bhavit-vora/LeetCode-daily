/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public String smallestSubsequence(String s) {
        boolean[] vis = new boolean[26];
        int[] freq = new int[26];
        for(char c: s.toCharArray()) freq[c - 'a']++;

        StringBuilder ans = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(!vis[c - 'a']) {
                while(ans.length() > 0 && ans.charAt(ans.length() - 1) > c && freq[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                    vis[ans.charAt(ans.length() - 1) - 'a'] = false;
                    ans.deleteCharAt(ans.length() - 1);
                }

                vis[c - 'a'] = true;
                ans.append(c);
            }

            freq[c - 'a']--;
        }

        return ans.toString();
    }
}