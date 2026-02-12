/*
    TC: O(n ^ 2)
    SC: O(26)
*/

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;

        for(int i = 0; i < n; i ++) {
            int[] freq = new int[26];
            int distinct = 0, max = 0;
            for(int j = i; j < n; j ++) {
                int idx = s.charAt(j) - 'a';
                if(freq[idx] == 0) distinct ++;
                freq[idx]++;
                if(freq[idx] > max) max = freq[idx];
                if(distinct * max == j - i + 1) ans = Math.max(ans, j - i + 1); 
            }
        }

        return ans;
    }
}