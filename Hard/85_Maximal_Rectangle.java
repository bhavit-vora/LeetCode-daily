/*
    TC: O(m * n)
    SC: O(m * n + n)
*/

import java.util.*;

class Solution {
    public int maximalRectangle(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == '0') grid[i][j] = 0;
                else grid[i][j] = 1;
            }
        }
        int max = 0;

        int i = 0;
        while(i < n) {
            int cnt = 0;
            while(i < n && mat[0][i] == '1') {
                cnt++;
                i++;
            }
            max = Math.max(max, cnt);
            i++;
        }

        for(i = 1; i < m; i++) {
            Stack<Integer> st = new Stack<>();
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) grid[i][j] += grid[i-1][j];
                while(!st.isEmpty() && grid[i][st.peek()] >= grid[i][j]) {
                    int idx = st.pop();
                    int val = grid[i][idx];
                    int nse = j;
                    int pse = st.size() == 0? -1: st.peek();
                    max = Math.max(max, val * (nse - pse - 1));
                }
                st.push(j);
            }

            while(!st.isEmpty()) {
                int idx = st.pop();
                int val = grid[i][idx];
                int nse = n;
                int pse = st.size() == 0? -1: st.peek();
                max = Math.max(max, val * (nse - pse - 1));
            }
        }

        return max;
    }
}