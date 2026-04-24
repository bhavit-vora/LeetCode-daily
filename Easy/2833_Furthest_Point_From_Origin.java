/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int x = 0, l = 0;
        for(int i =0; i < moves.length(); ++i) {
            if(moves.charAt(i) == 'L') 
                l++;
            else if (moves.charAt(i) == 'R') 
                l--;
            else 
                x ++;
        }
        return Math.abs(l) + x;
    }
}