/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int largestAltitude(int[] gain) {
        int cur = 0, max = 0;
        for(int i: gain) {
            cur += i;
            max = Math.max(max, cur);
        }

        return max;
    }
}