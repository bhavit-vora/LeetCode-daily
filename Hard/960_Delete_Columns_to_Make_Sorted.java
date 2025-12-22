/*
    TC: O(n * len * len)
    SC: O(len)
*/

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        
        int[] dp = new int[len];

        int max = 1;
        for(int i = 0; i < len; i ++) {
            dp[i] = 1;
            for(int j = 0; j < i; j ++) {
                boolean flag = true;
                for(int k = 0; k < n; k ++) {
                    if(strs[k].charAt(j) > strs[k].charAt(i)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
        }

        return len - max;
    }
}