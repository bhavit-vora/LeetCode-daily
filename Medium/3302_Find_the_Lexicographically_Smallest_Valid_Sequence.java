/*
    TC: O(m + n)
    SC: O(m + n)
*/

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];
        int[] match = new int[n + 1];

        int i = n - 1, j = m - 1;
        int cnt = 0;
        while(i >= 0) {
            if(j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
                cnt++;
            }

            match[i--] = cnt;
        }
        
        i = 0; j = 0;
        boolean flag = true;
        while(i < n && j < m) {
            if(word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i++;
            } else if(flag && match[i + 1] >= m - j - 1) {
                flag = false;
                ans[j++] = i++;
            } else {
                i++;
            }
        }

        return j == m? ans: new int[0];
    }
}