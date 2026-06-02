/*
    TC: O(n * m)
    SC: O(1)
*/

class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int n = lst.length, m = wst.length;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++ i) {
            for(int j = 0; j < m; ++ j) {
                int f = lst[i] + ld[i];
                if(wst[j] <= f) f += wd[j];
                else f = wst[j] + wd[j];

                int s = wst[j] + wd[j];
                if(lst[i] <= s) s += ld[i];
                else s = lst[i] + ld[i];

                min = Math.min(min, Math.min(f, s));
            }
        }

        return min;
    }
}