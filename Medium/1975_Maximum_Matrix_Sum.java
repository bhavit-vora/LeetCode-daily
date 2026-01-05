/*
    TC: O(m * n)
    SC: O(1)
*/

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = 1000000;
        int cnt = 0;

        for(int[] i: matrix) {
            for(int j: i) {
                if(j < 0) {
                    sum -= j;
                    cnt++;
                    min = Math.min(min, -j);
                } else {
                    sum += j;
                    min = Math.min(min, j);
                }
            }
        }
        
        return (cnt & 1) == 1? sum - 2 * min: sum;
    }
}