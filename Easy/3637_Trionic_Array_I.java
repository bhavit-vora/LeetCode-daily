/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums[0] >= nums[1]) return false;

        int cnt = 0;
        boolean flag = true;
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] < nums[i-1]) {
                if(flag) {
                    flag = !flag;
                    cnt++;
                }
            } else if(nums[i] > nums[i-1]) {
                if(!flag) {
                    flag = !flag;
                    cnt++;
                }
            } else {
                return false;
            }
        }

        return cnt == 2;
    }
}