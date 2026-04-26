class Solution {
    public static int[] dir = {1, 0, -1, 0, 1};

    public boolean dfs(char[][] grid, boolean[][] vis, char ch, int i, int j, int pi, int pj) {
        vis[i][j] = true;
        
        for(int k = 0; k < 4; ++ k) {
            int ni = i + dir[k];
            int nj = j + dir[k+1];

            if(ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length || grid[ni][nj] != ch) return false;
            if(vis[ni][nj]) {
                if(pi != ni &&pj != nj) return true;
            } else {
                if(dfs(grid, vis, ch, ni, nj, i, j)) return true;
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; ++ i) {
            for(int j = 0; j < m; ++ j) {
                if(!vis[i][j] && dfs(grid, vis, grid[i][j], i, j, -1, -1)) return true;
            }
        }

        return false;
    }
}