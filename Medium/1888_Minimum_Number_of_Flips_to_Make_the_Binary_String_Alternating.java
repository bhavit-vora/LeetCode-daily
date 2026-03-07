/*
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public int minFlips(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        sb.append(s).append(s);

        int ops = n;
        int l = 0;
        int flips1 = 0, flips2 = 0;
        for(int r = 0; r < 2 * n; ++ r) {
            if(sb.charAt(r)-'0' != (r & 1)) flips1++;
            if(sb.charAt(r)-'0' != 1 - (r & 1)) flips2++;

            if(r - l + 1 == n) {
                ops = Math.min(ops, Math.min(flips1, flips2));
                if(sb.charAt(l)-'0' != (l & 1)) flips1--;
                if(sb.charAt(l)-'0' != 1 - (l & 1)) flips2--;
                l++;
            }
        }

        return ops;
    }
}