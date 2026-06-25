/*
    TC: O(n * n)
    SC: O(1)
*/

class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int cnt = 0;

        for(int i = 0; i < n; ++ i) {
            int c = 0;
            for(int j = i; j < n; ++ j) {
                if(target == nums[j]) c++;
                if(2 * c > j - i + 1) cnt++;
            }
        }

        return cnt;
    }
}