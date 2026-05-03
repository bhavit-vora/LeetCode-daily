/*
    TC: O(n ^ 2)
    SC: O(n)
*/

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        goal += goal;
        for(int i = 0; i < goal.length(); ++ i) {
            int j = 0, ii = i;
            while(j < s.length() && ii < goal.length() && s.charAt(j) == goal.charAt(ii)) {
                ii++; j++;
            }

            if(j == s.length()) return true;
        }
        return false;
    }
}