/*
    TC: O(10000)
    SC: O(10000)
*/

class Solution {
    static int[] pref = new int[10001];

    public void calc() {
        for(int i = 1; i < 10001; ++ i) {
            boolean flag = false;
            int j = i;
            while(j > 0) {
                int d = j % 10;
                if(d == 3 || d == 4 || d == 7) {
                    flag = false;
                    break;
                } else if(d == 2 || d == 5 || d == 6 || d == 9) flag = true;
                j /= 10;
            }

            pref[i] = flag? 1: 0;
        }

        for(int i = 1; i < 10001; ++ i) pref[i] += pref[i-1];
    }

    public int rotatedDigits(int n) {
        if(pref[131] == 0) calc();
        return pref[n];
    }
}