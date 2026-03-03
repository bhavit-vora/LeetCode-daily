/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public char findKthBit(int n, int k) {
        if(k == 1) return '0';
        if((k & (k-1)) == 0) return '1';

        int pivot = 1 << (n-1);

        if(k < pivot) {
            return findKthBit(n-1, k);
        }

        char ch = findKthBit(n-1, 2 * pivot - k);
        return ch == '0'? '1': '0';
    }
}