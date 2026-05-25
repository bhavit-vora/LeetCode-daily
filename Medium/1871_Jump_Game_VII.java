/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public boolean canReach(String s, int min, int max) {
        int n = s.length();
        int[] pref = new int[n + max + 1];
        pref[min] = 1;
        pref[max + 1] = -1;

        int i = min;
        while(i < n) {
            pref[i] += pref[i-1];
            if(s.charAt(i) == '1' || pref[i] == 0) {
                i++;
                continue;
            }

            if(i == n - 1) return true;
            pref[i + min] += 1;
            pref[i + max + 1] -= 1;
            i++;
        }

        return false;
    }
}