/*
    TC: O(k * k)
    SC: O(1)
*/

class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        for(int j = y; j < y + k; ++ j) {
            int st = x, en = x + k - 1;
            for(int i = x; i < x + k / 2; ++ i) {
                int temp = grid[st][j];
                grid[st++][j] = grid[en][j];
                grid[en--][j] = temp;
            }
        }

        return grid;
    }
}