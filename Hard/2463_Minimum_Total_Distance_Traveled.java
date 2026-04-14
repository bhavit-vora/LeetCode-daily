/*
    TC: O(robots * factories)
    SC: O(robots * factories)
*/

import java.util.*;

class Solution {
    public long helper(List<Integer> robot, List<Integer> factory, int i, int j, long[][] dp) {
        if(i == robot.size()) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        long take = Math.abs(robot.get(i) - factory.get(j)) + helper(robot, factory, i + 1, j + 1, dp);
        long skip = Long.MAX_VALUE >> 8;
        if(robot.size() - i < factory.size() - j) skip = helper(robot, factory, i, j + 1, dp);
        return dp[i][j] = Math.min(take, skip);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        List<Integer> fact = new ArrayList<>();
        for(int[] i: factory) {
            for(int j = 0; j < i[1]; ++ j) {
                fact.add(i[0]);
            }
        }

        long[][] dp = new long[n][fact.size()];
        for(long[] i: dp) Arrays.fill(i, -1);
        return helper(robot, fact, 0, 0, dp);
    }
}