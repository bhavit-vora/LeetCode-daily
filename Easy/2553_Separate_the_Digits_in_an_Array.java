/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;

        for(int i = n - 1; i >= 0; -- i) {
            int x = nums[i];
            while(x > 0) {
                temp.add(x % 10);
                x /= 10;
            }
        }

        Collections.reverse(temp);
        int[] ans = new int[temp.size()];

        for(int i = 0; i < temp.size(); ++ i) ans[i] = temp.get(i);
        return ans;
    }
}