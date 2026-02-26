/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int numSteps(String s) {
        int ans = 0;
        int carry = 0;

        for(int i = s.length() - 1; i > 0; i --) {
            int sum = carry + s.charAt(i) - '0';
            if(sum == 1) {
                carry = 1;
                ans += 2;
            } else {
                ans++;
            }
        }

        return ans + carry;
    }
}