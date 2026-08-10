/*
    TC: O(1)
    SC: O(1)
*/

class Solution {
    public static boolean[] arr = new boolean[100001];
    public boolean winnerSquareGame(int n) {
        if(!arr[1]) {
            arr[1] = true;
            for(int i = 1; i <= 100000; ++ i) {
                int j = 1; 
                while(i - (j * j) >= 0) {
                    if(!arr[i - (j * j)]) {
                        arr[i] = true;
                        break;
                    }
                    j++;
                }
            }
        }

        return arr[n];
    }
}