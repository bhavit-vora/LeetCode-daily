/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char c: text.toCharArray()) freq[c - 'a']++;
        return Math.min(freq[0], Math.min(freq[1], Math.min(freq[11] / 2, Math.min(freq[13], freq[14] / 2))));
    }
}