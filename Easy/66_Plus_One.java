/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length-1] +=1;
        for(int i=digits.length-1;i>=0;i--){
            if(carry == 1) {
                digits[i] += 1;
            }
            if(digits[i] == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                carry = 0;
            }
            if(carry == 0) {
                return digits;
            }
        }
        int[] arr = new int[digits.length+1];
        arr[0] = 1;
        for(int i=1;i<arr.length;i++){
            arr[i] = 0;
        }
        return arr;
    }
}