/*
    TC: O(1)
    SC: O(1)
*/

class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n >> 1;
        return ((n ^ x) & ((n ^ x) + 1)) == 0;
    }
}