/*
    TC: O(n * m * ((k ^ 2) * log(k ^ 2)))
    SC: O(k ^ 2)
*/

import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        if(k == 1) return new int[n][m];

        int[][] ans = new int[n-k+1][m-k+1];

        for(int i = 0; i < n - k + 1; ++ i) {
            for(int j = 0; j < m - k + 1; ++ j) {
                List<Integer> l = new ArrayList<>();
                for(int x = i; x < i + k; ++ x) {
                    for(int y = j; y < j + k; ++ y) {
                        l.add(grid[x][y]);
                    } 
                }

                Collections.sort(l);
                int val = Integer.MAX_VALUE;
                for(int t = 1; t < l.size(); ++ t) {
                    if(l.get(t).equals(l.get(t - 1))) continue;
                    val = Math.min(val, l.get(t) - l.get(t-1));
                }

                ans[i][j] = val == Integer.MAX_VALUE? 0: val;
            }
        }

        return ans;
    }
}