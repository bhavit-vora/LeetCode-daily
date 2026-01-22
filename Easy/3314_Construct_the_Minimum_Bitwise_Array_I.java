/*
    TC: O(100 * n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0; i < n; i ++) {
            int num = nums.get(i);

            if(num == 2) ans[i] = -1;
            
            for(int j = 1; j < num; j ++) {
                if((j | (j + 1)) == num) {
                    ans[i] = j;
                    break;
                }
            }
        }

        return ans;
    }
}