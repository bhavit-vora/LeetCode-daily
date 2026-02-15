/*
    TC: O(max(len(a), len(b)))
    SC: O(len(a) + len(b))
*/

class Solution {
    public String addBinary(String a, String b) {
        if(b.length() > a.length()) return addBinary(b, a);

        StringBuilder na = new StringBuilder(a);
        StringBuilder nb = new StringBuilder(b);

        na.reverse();
        nb.reverse();

        int i = 0;
        int c = 0;
        StringBuilder ans = new StringBuilder();

        while(i < a.length()) {
            int t = 0;
            int u = 0;
            if(i < nb.length() && nb.charAt(i) == '1') t = 1;
            if(i < na.length() && na.charAt(i) == '1') u = 1;

            if(t == 1 && u == 1) {
                if(c == 1) {
                    ans.append(1);
                } else {
                    c = 1;
                    ans.append(0);
                }
            } else if(t == 1 || u == 1) {
                if(c == 1) {
                    ans.append(0);
                } else {
                    ans.append(1);
                }
            } else {
                if(c == 1) {
                    c = 0;
                    ans.append(1);
                } else {
                    ans.append(0);
                }
            }

            i++;
        }

        if(c == 1) ans.append(c);
        return ans.reverse().toString();
    }
}