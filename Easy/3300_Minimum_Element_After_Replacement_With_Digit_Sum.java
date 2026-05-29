/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int minElement(int[] nums) {
        int min = nums[0];

        for(int i: nums) {
            int sum = 0;
            while(i > 0) {
                sum += i % 10;
                i /= 10;
            }
            
            min = Math.min(min, sum);
        }

        return min;
    }
}