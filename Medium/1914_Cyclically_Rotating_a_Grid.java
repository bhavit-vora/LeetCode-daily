/*
    TC: O(m * n)
    SC: O(m * n)
*/

import java.util.*;

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        for(int iter = 0; iter < Math.min(m, n) / 2; ++ iter) {
            List<Integer> list = new ArrayList<>();

            int i = iter, j = iter;
            while(j < n - iter - 1) list.add(grid[i][j++]);
            while(i < m - iter - 1) list.add(grid[i++][j]);
            while(j > iter) list.add(grid[i][j--]);
            while(i > iter) list.add(grid[i--][j]);

            int rot = k % list.size();
            int idx = 0;
            i = j = iter;
            while(j < n - iter - 1) ans[i][j++] = list.get((rot + idx++) % list.size());
            while(i < m - iter - 1) ans[i++][j] = list.get((rot + idx++) % list.size());
            while(j > iter) ans[i][j--] = list.get((rot + idx++) % list.size());
            while(i > iter) ans[i--][j] = list.get((rot + idx++) % list.size());

        }

        return ans;
    }
}