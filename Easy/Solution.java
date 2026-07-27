/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int maxProduct(int[] nums) {
        int max = 0, max2 = 0;
        for(int i: nums) {
            if(i > max) {
                max2 = Math.max(max, max2);
                max = i;
            } else if(i > max2) {
                max2 = i;
            }
        }

        return (max - 1) * (max2 - 1);
    }
}