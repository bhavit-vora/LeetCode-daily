/*
    Memoization: 
        TC: O(n * m)
        SC: O(n * m + max(n, m))
    Tabulation:
        TC: O(n * m)
        SC: O(n * m)
*/

class Solution {
    public int[][] dp;

    // memoization
    public int helper(int i, int j, String s, String t) {
        if(i == s.length() || j == t.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int sum = 0;
        if(s.charAt(i) == t.charAt(j)) {
            sum = s.charAt(i) + helper(i+1, j+1, s, t);
        }

        sum = Math.max(sum, helper(i+1, j, s, t));
        sum = Math.max(sum, helper(i, j+1, s, t));

        return dp[i][j] = sum;
    }

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new int[n+1][m+1];

        // for memo
        // for(int[] i: dp) Arrays.fill(i, -1);

        int sum = 0;
        for(int i = 0; i < n; i ++) sum += s1.charAt(i);
        for(int i = 0; i < m; i ++) sum += s2.charAt(i);

        // tabulation
        for(int i = n-1; i >= 0; i --) {
            for(int j = m-1; j >= 0; j --) {
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = s1.charAt(i) + dp[i+1][j+1];
                dp[i][j] = Math.max(dp[i][j], dp[i+1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j+1]);
            }
        }

        return sum - 2 * dp[0][0];
    }
}