/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = nums[0];
        int mindex = 1;

        int max = nums[0];
        int maxdex = 1;

        for(int i = 0; i < n; ++ i) {
            if(nums[i] < min) {
                min = nums[i];
                mindex = i + 1;
            } if(nums[i] > max) {
                max = nums[i];
                maxdex = i + 1;
            }
        }

        int a = Math.min(mindex, maxdex);
        int b = Math.max(mindex, maxdex);

        return Math.min(a + n - b + 1, Math.min(b, n - a + 1));
    }
}