/*
    TC: O(26 * n)
    SC: O(1)
*/

class Solution {
    public int numberOfSpecialChars(String word) {
        int cnt = 0;

        for(int i = 0; i < 26; ++ i) {
            int f = -1, l = -1;
            for(int j = 0; j < word.length(); ++ j) if(word.charAt(j) - 'a' == i) f = j;
            for(int j = word.length() - 1; j >= 0; -- j) if(word.charAt(j) - 'A' == i) l = j;
            if(f >= 0 && l > f) cnt++;
        }

        return cnt;
    }
}