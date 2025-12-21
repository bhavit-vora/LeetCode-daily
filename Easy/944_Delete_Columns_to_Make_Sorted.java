/*
    TC: O(n * len)
    SC: O(1)
*/

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        int ans = 0;

        for(int j = 0; j < len; j ++) {
            char ch = 'a';
            for(int i = 0; i < n; i ++) {    
                if(strs[i].charAt(j) < ch) {
                    ans++;
                    break;
                } else {
                    ch = strs[i].charAt(j);
                }
            }
        }

        return ans;
    }
}