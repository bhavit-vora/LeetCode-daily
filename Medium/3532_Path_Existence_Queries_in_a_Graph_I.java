/*
    TC: O(n + q)
    SC: O(q)
*/

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int max, int[][] queries) {
        int[] par = new int[n];

        int i = 0;
        while(i < n) {
            par[i] = i;
            int j = i + 1;
            while(j < n && nums[j] - nums[j-1] <= max) {
                par[j] = i;
                j++;
            }

            i = j;
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];

        for(i = 0; i < q; ++ i) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = par[u] == par[v];
        }

        return ans;
    }
}