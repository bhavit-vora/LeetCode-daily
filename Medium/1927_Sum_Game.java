/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public boolean sumGame(String s) {
        int i = 0;
        int sum1 = 0;
        int q1 = 0;
        while(i<s.length()/2){
            if(s.charAt(i)=='?') q1++;
            else sum1+= s.charAt(i)-'0';
            i++;
        }
        int sum2 = 0;
        int q2 = 0;
        while(i<s.length()){
            if(s.charAt(i)=='?') q2++;
            else sum2+= s.charAt(i)-'0';
            i++;
        }
        return ((q1 + q2) % 2 != 0) || ((sum1 - sum2) != ((q2 - q1) / 2) * 9);
    }
}