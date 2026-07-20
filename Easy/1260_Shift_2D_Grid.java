/*
    TC: O(m * n)
    SC: O(m * n)
*/

import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = (m * n - (k % (m * n))) % (m * n);

        int r = k / n;
        int c = k % n;

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; ++ i) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; ++ j) {
                temp.add(grid[r][c++]);
                if(c == n) {
                    r = (r + 1) % m;
                    c = 0;
                }
            }

            ans.add(temp);
        }

        return ans;
    }
}