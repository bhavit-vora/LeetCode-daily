/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] ans = new int[n];

        int cnt = 0;
        int[] pref = new int[n + 1];
        for(int i = 0; i < n; ++ i) {
            if(A[i] == B[i]) cnt++;
            else {
                pref[A[i]]++;
                pref[B[i]]++;
            }

            if(pref[A[i]] == 2) cnt++;
            if(pref[B[i]] == 2) cnt++;
            ans[i] = cnt;
        }

        return ans;
    }
}