/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int missingInteger(int[] nums) {
        int[] freq = new int[52];
        for(int i: nums) freq[i] = 1;

        int ans = nums[0];
        int cur = nums[0];
        for(int i = 1; i < nums.length; ++ i) {
            if(nums[i] == cur + 1) {
                ans += nums[i];
                cur++;
            } else break;
        }

        if(ans > 50) return ans;

        while(freq[ans] == 1) ans++;
        return ans;
    }
}