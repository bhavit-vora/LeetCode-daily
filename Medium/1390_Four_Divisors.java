/*
    TC: O((maxLimit * sqrt(i)) + n) approx
    SC: O(maxLimit)
*/

class Solution {
    public int[] arr = new int[100001];
    
    public int count(int n) {
        int cnt = 0;
        int sum = 0;

        for(int i = 1; i * i <= n; i ++) {
            if(n % i == 0) {
                if(i == n / i) {
                    cnt++;
                    sum += i;
                } else {
                    cnt += 2;
                    sum += i;
                    sum += n / i;
                }
            }
        }

        return cnt == 4? sum: -1;
    }

    public int sumFourDivisors(int[] nums) {
        if(arr[0] == 0) {
            arr[0] = -1;
            for(int i = 1; i < 100001; i ++) {
                arr[i] = count(i);
            }
        }

        int sum = 0;
        for(int i: nums) {
            if(arr[i] != -1) sum += arr[i];
        }

        return sum;
    }
}