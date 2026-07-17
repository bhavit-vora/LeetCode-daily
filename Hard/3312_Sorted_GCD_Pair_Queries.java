/*
    TC: O(n * log(logn))
    SC: O(n)
*/

class Solution {

    public void find(int num, long[] factors) {
        for(int i = 1; i * i <= num; ++ i) {
            if(num % i == 0) {
                factors[i]++;
                if(i != num / i) factors[num / i]++;
            }
        }
    }

    public int lower_bound(long[] factors, long target) {
        int low = 0, high = factors.length - 1;

        while(low <= high) {
            int mid = (low + high) >> 1;
            if(factors[mid] >= target) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for(int i: nums) max = Math.max(max, i);

        long[] factors = new long[max + 1];
        for(int i: nums) find(i, factors);
        for(int i = 1; i <= max; i++) factors[i] = factors[i] * (factors[i] - 1) / 2;

        for(int i = max; i > 0; -- i) {
            for(int j = 2 * i; j <= max; j += i) {
                factors[i] -= factors[j];
            }
        }

        for(int i = 1; i <= max; ++ i) factors[i] += factors[i-1];

        int q = queries.length;
        int[] ans = new int[q];
        for(int i = 0; i < q; ++ i) {
            ans[i] = lower_bound(factors, queries[i] + 1);
        }

        return ans;
    }
}