/*
    TC: O(n * n * logn)
    SC: O(n * n)
*/

import java.util.*;

class Solution {
    
    static int[] dir = {1, 0, -1, 0, 1};

    public boolean possible(int[][] mat, int mid) {
        int n = mat.length;

        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        if(mat[0][0] >= mid) {
            q.offer(new int[]{0, 0});
            vis[0][0] = true;
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == n - 1 && cur[1] == n - 1) return true;

            for(int d = 0; d < 4; ++ d) {
                int i = cur[0] + dir[d];
                int j = cur[1] + dir[d + 1];

                if(i < 0 || j < 0 || i >= n || j >= n || vis[i][j] || mat[i][j] < mid) continue;
                q.offer(new int[]{i, j});
                vis[i][j] = true;
            }
        }

        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int[][] mat = new int[n][n];

        for(int i = 0; i < n; ++ i) {
            for(int j = 0; j < n; ++ j) {
                mat[i][j] = grid.get(i).get(j);
                if(grid.get(i).get(j) == 1) pq.offer(new int[]{i, j, 1});
            }
        }

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1];

            for(int d = 0; d < 4; ++ d) {
                int ni = i + dir[d];
                int nj = j + dir[d + 1];

                if(ni < 0 || nj < 0 || ni >= n || nj >= n || mat[ni][nj] != 0) continue;

                mat[ni][nj] = cur[2] + 1;
                pq.offer(new int[]{ni, nj, cur[2] + 1});
            }
        }

        int low = 0, high = n;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(possible(mat, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high - 1;
    }
}