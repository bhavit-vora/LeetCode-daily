/*
    TC: O(32 * n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0; i < n; i ++) {
            if(nums.get(i) == 2) {
                ans[i] = -1;
                continue;
            }

            int x = nums.get(i);
            int cnt = 0;
            while((x & 1) == 1) {
                cnt++;
                x >>= 1;
            }

            ans[i] = nums.get(i) ^ (1 << (cnt-1));
        }

        return ans;
    }
}