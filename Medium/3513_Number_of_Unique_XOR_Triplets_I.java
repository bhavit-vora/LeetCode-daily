/*
    TC: O(1)
    SC: O(1)
*/

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length <= 2) return nums.length;
        if(nums.length == 3) return nums.length + 1;
        return (int) Math.pow(2, (int)(Math.log(nums.length) / Math.log(2)) + 1);
    }
}