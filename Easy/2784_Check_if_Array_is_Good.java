/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; ++ i) {
            if(nums[i] >= n) return false;
            if(nums[i] == n - 1) {
                if(vis[n-1] && vis[n-2]) return false;
                else if(vis[n-2]) vis[n-1] = true;
                else vis[n-2] = true; 
            } else {
                if(vis[nums[i] - 1]) return false;
            }

            vis[nums[i] - 1] = true;
        }

        return true;
    }
}