/*
    TC: O(n ^ 3)
    SC: O(1)
*/

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        int min = 1000000;

        for(int i = 0; i < n; ++ i) {
            for(int j = i + 1; j < n; ++ j) {
                for(int k = j + 1; k < n; ++ k) {
                    if(nums[i] == nums[j] && nums[j] == nums[k]) {
                        min = Math.min(min, k - i + k - i);
                    }
                }
            }
        }

        return min == 1000000? -1: min;
    }
}