/*
    TC: O(len(s))
    SC: O(1)
*/

class Solution {
    public int minPartitions(String s) {
        int n = s.length();
        int max = 0;
        int i = 0;
        while(i < n) {
            int digit = s.charAt(i) - '0';
            max = Math.max(digit, max);
            i++;
        }

        return max;
    }
}