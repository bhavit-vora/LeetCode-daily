/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int a = 0, b = 0;
        for(int i = 0; i < n; ++ i) {
            if(colors[i] != colors[0]) a = i;
            if(colors[i] != colors[n-1]) b = Math.max(b, n - i - 1); 
        }

        return Math.max(a, b);
    }
}