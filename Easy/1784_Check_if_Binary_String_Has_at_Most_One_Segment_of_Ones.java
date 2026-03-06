/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public boolean checkOnesSegment(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) == '1') i++;
        while(i < s.length() && s.charAt(i) == '0') i++;
        return i == s.length();
    }
}