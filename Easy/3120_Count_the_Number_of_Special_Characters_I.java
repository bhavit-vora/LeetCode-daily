/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int numberOfSpecialChars(String word) {
        int lower = 0;
        int upper = 0;

        for(char c: word.toCharArray()) {
            if(c >= 'a') lower |= (1 << (c - 'a'));
            else upper |= (1 << (c - 'A'));
        }

        int cnt = 0;
        for(int i = 0; i < 26; ++ i) {
            if(((lower >> i) & 1) == ((upper >> i) & 1) && ((lower >> i) & 1) != 0) cnt++;
        }

        return cnt;
    }
}