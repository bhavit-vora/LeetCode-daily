/*
    TC: O(1)
    SC: O(1)
*/

class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, prod = 1;
        int m = n;

        while(n > 0) {
            int d = n % 10;
            n /= 10;
            sum += d;
            prod *= d;
        }

        return m % (sum + prod) == 0;
    }
}