/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '*') { if(len > 0) len--; }
            else if(ch == '#') len *= 2;
            else if(ch == '%') len += 0;
            else len++;
        }

        if(k >= len) return '.';

        int n = s.length();
        for(int i = n - 1; i >= 0; -- i) {
            char ch = s.charAt(i);

            if(ch == '#') {
                len /= 2;
                if(k >= len) k -= len;
            } else if(ch == '%') {
                k = len - k - 1;
            } else if(ch == '*') {
                len++;
            } else {
                len--;
            }

            if(k == len) return ch;
        }

        return '.';
    }
}