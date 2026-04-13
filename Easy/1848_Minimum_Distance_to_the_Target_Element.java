/*
    TC: (n)
    SC: O(1)
*/

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;

        int l = start, r = start;
        while(l >= 0) {
            if(nums[l] == target) break;
            l--;
        }

        while(r < n) {
            if(nums[r] == target) break;
            r++;
        }

        if(l == -1) {
            return r - start;
        }
        if(r == n) {
            return start - l;
        }
        return Math.min(start - l, r - start);
    }
}