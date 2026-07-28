/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        boolean single = false;
        char sin = ' ';

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; ++ i) {
            if(freq[i] % 2 == 1) {
                single = true;
                sin = (char)('a' + i);
            }

            int c = 1;
            while(c < freq[i]) {
                sb.append((char)('a' + i));
                c += 2;
            }
        }

        if(single) sb.append(sin);

        for(int i = 25; i >= 0; -- i) {
            int c = 1;
            while(c < freq[i]) {
                c += 2;
                sb.append((char)('a' + i));
            }
        }

        return sb.toString();
    }
}