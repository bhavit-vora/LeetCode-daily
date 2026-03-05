/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int minOperations(String s) {
        int ops = 0;
        boolean f = true;

        for(int i = 0; i < s.length(); ++ i) {
            char ch = s.charAt(i);
            if(f && ch == '0') ops++;
            else if(!f && ch == '1') ops++;
            f = !f;
        }

        return Math.min(ops, s.length() - ops);
    }
}