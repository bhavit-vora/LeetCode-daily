/*
    TC: O(logn)
    SC: O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        
        int low = 0, high = n - 1;
        while(low <= high) {
            int mid = (low + high) >> 1;

            if((mid - 1 < 0 || nums[mid - 1] > nums[mid]) && (mid + 1 >= n || nums[mid + 1] > nums[mid])) return nums[mid];

            if(nums[mid] > nums[high]) low = mid + 1;
            else high = mid - 1;
        }

        return nums[low];
    }
}