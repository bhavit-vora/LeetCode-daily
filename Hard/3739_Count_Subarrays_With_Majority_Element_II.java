/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int pref = 0;
        long ans = 0;
        int left = 0;

        int[] map = new int[200001]; map[n] = 1;
        for(int i = 0; i < n; ++ i) {
            if(nums[i] == target) {
                left += map[pref + n];
                pref++;
            } else {
                left -= map[pref - 1 + n];
                pref--;
            }

            ans += left;
            map[pref + n]++;
        }

        return ans;
    }
}