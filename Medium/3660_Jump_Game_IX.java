/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] prefMax = new int[n];
        prefMax[0] = nums[0];
        for(int i = 1; i < n; ++ i) prefMax[i] = Math.max(nums[i], prefMax[i-1]);

        int[] suffMin = new int[n];
        suffMin[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; -- i) suffMin[i] = Math.min(nums[i], suffMin[i+1]);

        ans[n-1] = prefMax[n-1];
        for(int i = n - 2; i >= 0; -- i) {
            if(prefMax[i] > suffMin[i+1]) ans[i] = ans[i+1];
            else ans[i] = prefMax[i];
        }

        return ans;
    }
}