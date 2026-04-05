/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public boolean judgeCircle(String moves) {
        int h = 0, v = 0;

        for(int i = 0; i < moves.length(); ++ i) {
            char ch = moves.charAt(i);
            if(ch == 'R') h++;
            if(ch == 'L') h--;
            if(ch == 'D') v++;
            if(ch == 'U') v--;
        }

        return h == 0 && v == 0;
    }
}