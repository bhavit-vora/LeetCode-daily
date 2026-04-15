/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int closestTarget(String[] words, String target, int st) {
        int n = words.length;
        int ans = n + 2;

        for(int i = 0; i < n; ++ i) {
            if(words[(st + i) % n].equals(target)) {
                ans = Math.min(ans, Math.min(i, n - i));
            }
        }

        return ans == n + 2? -1: ans;
    }
}