/*
    TC: O(n * m * min(n, m))
    SC: O(n * m)
*/

import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        int[][] d1 = new int[n+1][m+2];
        int[][] d2 = new int[n+1][m+2];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                d1[i][j] = grid[i-1][j-1] + d1[i-1][j-1];
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=m;j>=1;j--){
                d2[i][j] = grid[i-1][j-1] + d2[i-1][j+1];
            }
        }

        TreeSet<Integer> set = new TreeSet<>((a,b)->b-a);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                set.add(grid[i][j]);

                for(int r=1;;r++){

                    int up=i-r, down=i+r, left=j-r, right=j+r;

                    if(up<0||down>=n||left<0||right>=m) break;

                    int a = d1[i+1][right+1]-d1[up][j];
                    int b = d2[i+1][left+1]-d2[up][j+2];
                    int c = d1[down+1][j+1]-d1[i][left];
                    int d = d2[down+1][j+1]-d2[i][right+2];

                    int val = a+b+c+d - grid[up][j] - grid[i][left] - grid[i][right] - grid[down][j];

                    set.add(val);
                    if(set.size()>3) set.pollLast();
                }
            }
        }

        int[] res = new int[Math.min(3, set.size())];
        int k=0;

        for(int x:set) {
            if(k==3) break;
            res[k++]=x;
        }

        return res;
    }
}