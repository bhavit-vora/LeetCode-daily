/*
    TC: O(n ^ 2)
    SC: O(n)
*/

import java.util.*;

class Solution {

    public boolean sorted(List<Integer> nums) {
        for(int i = 0; i < nums.size()-1; i ++) {
            if(nums.get(i+1) < nums.get(i)) return false;
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for(int i: nums) list.add(i);

        int cnt = 0;
        for(int i = 0; i < nums.length; i ++) {
            int min = 100000000; int idx = -1;
            for(int j = 0; j < list.size()-1; j ++) {
                if(list.get(j) + list.get(j+1) < min) {
                    min = list.get(j) + list.get(j+1);
                    idx = j;
                }
            }

            if(sorted(list)) return cnt;

            list.remove(idx);
            list.remove(idx);
            list.add(idx, min);
            cnt++;
        }

        return -1;
    }
}
