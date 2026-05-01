class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int ans = 0;
        int sum = 0;

        for(int i: nums) sum += i;
        for(int i = 0; i < n; ++ i) ans += nums[i] * i;

        int temp = ans;        
        for(int i = n-1; i >= 0; -- i) {
            temp -= nums[i] * n;
            temp += sum;
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}