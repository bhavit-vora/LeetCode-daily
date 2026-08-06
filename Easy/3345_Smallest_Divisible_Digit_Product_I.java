/*
    TC: O(1)
    SC: O(1)
*/

class Solution {
    public int digits(int num) {
        int prod = 1;
        while(num > 0) {
            prod = prod * (num % 10);
            num /= 10;
        }
        return prod;
    }

    public int smallestNumber(int n, int t) {
        for(int i = n; i < n + 10; i ++) {
            if(digits(i) % t == 0) return i;
        }

        return 0;
    }
}