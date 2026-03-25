/*
    TC: O(n * m)
    SC: O(n + m)
*/

import java.util.*;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long sum = 0;
        Set<Long> set = new HashSet<>();

        for(int i = 0; i < m; ++ i) {
            for(int j = 0; j < n; ++ j) {
                sum += grid[i][j];
            }

            set.add(sum);
        }

        if(set.contains(sum / 2) && sum % 2 == 0) return true;

        sum = 0;
        set = new HashSet<>();

        for(int j = 0; j < n; ++ j) {
            for(int i = 0; i < m; ++ i) {
                sum += grid[i][j];
            }

            set.add(sum);
        }

        return set.contains(sum / 2) && sum % 2 == 0;   
    }
}