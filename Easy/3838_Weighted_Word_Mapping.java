/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < words.length; i ++) {
            int sum = 0;
            for(int j = 0; j < words[i].length(); j ++) {
                sum += weights[words[i].charAt(j) - 'a'];
            }

            sum %= 26;
            sum = 26 - sum - 1;
            sb.append((char)(sum + 'a'));
        }

        return sb.toString();
    }
}