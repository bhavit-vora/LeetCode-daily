/*
    TC: O(n * len)
    SC: O(n)
*/

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();

        int cnt = 0;
        boolean[] vis = new boolean[n];

        for (int col = 0; col < len; col++) {
            boolean flag = false;

            for (int row = 0; row < n - 1; row++) {
                if (!vis[row] &&
                    strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    cnt++;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                continue;
            }

            for (int i = 0; i < n - 1; i++) {
                vis[i] = vis[i] ||
                        (strs[i].charAt(col) < strs[i + 1].charAt(col));
            }
        }

        return cnt;
    }
}