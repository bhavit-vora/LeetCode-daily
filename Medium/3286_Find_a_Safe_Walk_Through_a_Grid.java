/*
    TC: O(m * n * log(m * n))
    SC: O(m * n)
*/

import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[] dir = {1, 0, -1, 0, 1};

        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid.get(0).get(0)});
        vis[0][0] = true;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1], h = cur[2];

            if(i == m - 1 && j == n - 1) return true;

            for(int d = 0; d < 4; ++ d) {
                int ni = i + dir[d];
                int nj = j + dir[d + 1];
                if(ni >= 0 && nj >= 0 && ni < m && nj < n && !vis[ni][nj]) {
                    if(grid.get(ni).get(nj) + h < health) {
                        pq.offer(new int[]{ni, nj, h + grid.get(ni).get(nj)});
                        vis[ni][nj] = true;
                    }
                }
            }
        }

        return false;
    }
}