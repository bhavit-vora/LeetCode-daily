/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            while(low < high && nums[low] == nums[low + 1]) low++;
            while(low < high && nums[high] == nums[high - 1]) high--;

            int mid = (low + high) >> 1;
            if(nums[mid] < ans) ans = nums[mid];
            if(nums[mid] > nums[high]) low = mid + 1;
            else high = mid - 1;
        }

        return ans;
    }
}