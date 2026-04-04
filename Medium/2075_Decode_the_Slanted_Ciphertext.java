/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < cols; ++ i) {
            int st = i;
            for(int j = 0; st < n && j < rows; ++ j) {
                ans.append(encodedText.charAt(st++));
                st += cols;
            }
        }

        while(ans.length() > 0 && ans.charAt(ans.length() - 1) == ' ') ans.deleteCharAt(ans.length() - 1);

        return ans.toString();
    }
}