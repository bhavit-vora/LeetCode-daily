/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        int ones = 0;
        int max = 0;
        int first = 0, second = 0;

        int i = 0;
        while(i < n) {
            int cnt = 0;
            while(i < n && s.charAt(i) == '0') {
                cnt++;
                i++;
            }

            while(i < n && s.charAt(i) == '1') {
                ones++;
                i++;
            }
            
            first = second;
            second = cnt;
            if(first != 0 && cnt != 0) max = Math.max(max, first + second);
        }

        return ones + max;
    }
}