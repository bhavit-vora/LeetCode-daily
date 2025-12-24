/*
    TC: O(nlogn + 2n) 
    SC: O(1)
*/

import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;
        for(int i: apple) sum += i;
        int i = capacity.length-1;
        while(sum > 0) {
            sum -= capacity[i--];
        }
        return capacity.length-i-1;
    }
}