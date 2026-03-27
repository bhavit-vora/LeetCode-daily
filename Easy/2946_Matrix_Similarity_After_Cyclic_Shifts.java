/*
    TC: O(n * m)
    SC: O(m)
*/

class Solution {
    public void reverse(int[] arr, int st, int en) {
        while(st < en) {
            int temp = arr[st];
            arr[st] = arr[en];
            arr[en] = temp;
            st++; en--;
        }
    }

    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        k %= m;

        for(int i = 0; i < n; ++ i) {
            int[] arr = new int[m];
            for(int j = 0; j < m; ++ j) arr[j] = mat[i][j];

            if((i & 1) == 1) {
                reverse(arr, 0, m - 1);
                reverse(arr, 0, m - k - 1);
                reverse(arr, m - k, m - 1);
            } else {
                reverse(arr, 0, m - k - 1);
                reverse(arr, m - k, m - 1);
                reverse(arr, 0, m - 1);
            }

            for(int j = 0; j < m; ++ j) {
                if(arr[j] != mat[i][j]) return false;
            }
        }

        return true;
    }
}