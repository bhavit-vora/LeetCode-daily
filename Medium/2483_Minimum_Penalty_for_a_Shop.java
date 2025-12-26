/*
    TC: O(2 * n)
    SC: O(1)
*/

class Solution {
    public int bestClosingTime(String s) {
        int ones = 0, zero = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == 'Y') ones++;
        }

        int ans = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i ++) {
            if(zero + ones < min) {
                min = ones + zero;
                ans = i;
            }
            if(s.charAt(i) == 'Y') ones--;
            else zero++;
        }

        if(ones + zero < min) {
            return s.length();
        }

        return ans;
    }
}