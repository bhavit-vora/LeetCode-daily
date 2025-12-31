/*
    TC: O(n * logn)
    SC: O(2n)
    n = row * col
*/

import java.util.*;

class Solution {

    static int[] directions = {1, 0, -1, 0, 1};

    // checking whether it's possible to cross or not using BFS
    public boolean possible(int[][] grid, int day) {

        Queue<int[]> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] vis = new boolean[row][col];

        for(int j = 0; j < col; j ++) {
            if(grid[0][j] > day) {
                vis[0][j] = true;
                q.offer(new int[]{0, j});
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == row - 1) return true;

            for(int dir = 0; dir < 4; dir ++) {
                int new_row = curr[0] + directions[dir];
                int new_col = curr[1] + directions[dir+1];

                if(new_row < 0 || new_row >= row || new_col < 0 || new_col >= col) continue;

                if(!vis[new_row][new_col] && grid[new_row][new_col] > day) {
                    vis[new_row][new_col] = true;
                    q.offer(new int[]{new_row, new_col});
                }
            }
        }

        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        int[][] grid = new int[row][col];

        int c = 1;
        for(int[] cell: cells) {
            int i = cell[0] - 1;
            int j = cell[1] - 1;
            grid[i][j] = c++;
        }

        int low = 1;
        int high = n-1;

        // binary search on days
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(possible(grid, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}