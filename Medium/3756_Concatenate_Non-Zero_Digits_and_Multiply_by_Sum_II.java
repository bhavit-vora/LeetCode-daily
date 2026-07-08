/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int mod = 1_000_000_007;
        
        int[] pref = new int[n];
        long[] nums = new long[n];
        long[] arr = new long[n+1];
        arr[0] = 1;
        int[] len = new int[n];
        
        if(s.charAt(0) != '0') {
            pref[0] = s.charAt(0) - '0';
            nums[0] = s.charAt(0) - '0';
            len[0]++;
        }

        for(int i=1;i<=n;i++) {
            arr[i] = (arr[i-1] * 10) % mod;
        }

        List<int[]> list = new ArrayList<>();
        if(s.charAt(0) != '0') list.add(new int[]{s.charAt(0)-'0', 0});

        for(int i=1;i<n;i++) {
            int num = s.charAt(i) - '0';
            pref[i] = pref[i-1] + num;
            nums[i] = nums[i-1];
            len[i] = len[i-1];
            if(num != 0) {
                list.add(new int[]{num, i});
                nums[i] = (nums[i] * 10 + num) % mod; 
                len[i]++;
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        long mul = 0, sum = 0;

        for(int i=0;i<q;i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if(l == 0) {
                mul = nums[r];
                sum = pref[r];
            } else {
                int length = len[r] - len[l-1];
                sum = pref[r] - pref[l-1];

                long extra = (nums[l-1] * arr[length]) % mod;
                mul = (nums[r] - extra + mod) % mod;
            }

            ans[i] = (int)((mul * sum) % mod);
        }

        return ans;
    }
}