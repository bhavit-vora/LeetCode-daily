/*
    TC: O(n * m * energy * (2 ^ litters))
    SC: O(n * m * energy * (2 ^ litters))
*/

import java.util.*;

class Solution {
    public int minMoves(String[] clas, int energy) {
        int n = clas.length;
        int m = clas[0].length();

        int bitPos = 0;
        int[][] litter = new int[n][m];
        int sr = -1, sc = -1;
        for(int i = 0; i < n; ++ i) {
            for(int j = 0; j < m; ++ j) {
                if(clas[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                } else if(clas[i].charAt(j) == 'L') {
                    litter[i][j] = bitPos++;
                }
            }
        }

        if(bitPos == 0) return 0;

        boolean[][][][] dp = new boolean[n][m][energy + 1][1 << bitPos];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sr, sc, energy, 0});
        dp[sr][sc][energy][0] = true;
        int[] dir = {1, 0, -1, 0, 1};

        int moves = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; ++ i) {
                int[] cur = q.poll();

                if(cur[3] == (1 << bitPos) - 1) return moves;
                if(cur[2] == 0) continue;

                int x = cur[0], y = cur[1];
                for(int d = 0; d < 4; ++ d) {
                    int nx = dir[d] + x;
                    int ny = dir[d + 1] + y;

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || clas[nx].charAt(ny) == 'X') continue;

                    int e = cur[2] - 1;
                    int l = cur[3];
                    if(clas[nx].charAt(ny) == 'R') e = energy;
                    if(clas[nx].charAt(ny) == 'L') {
                        int pos = litter[nx][ny];
                        l |= (1 << pos);
                    }

                    if(dp[nx][ny][e][l]) continue;
                    dp[nx][ny][e][l] = true;
                    q.offer(new int[]{nx, ny, e, l});
                }
            }

            moves++;
        }

        return -1;
    }
}