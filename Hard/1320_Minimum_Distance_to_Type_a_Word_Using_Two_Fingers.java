/*
    TC: O(27 * 27 * n)
    SC: O(n)
*/

import java.util.*;

class Solution {

    public int calc(Map<Character, int[]> map, char ch1, char ch2, int i, String s, int[][][] dp) {
        if(i == s.length()) return 0;

        int a = ch1 == '#'? 26: ch1 - 'A';
        int b = ch2 == '#'? 26: ch2 - 'A';

        if(dp[a][b][i] != -1) return dp[a][b][i];
    
        int[] t = map.get(s.charAt(i));
        int x = t[0], y = t[1];

        int first = 0, second = 0;

        if(ch1 == '#') {
            first = calc(map, s.charAt(i), ch2, i + 1, s, dp);
        } else {
            int[] fir = map.get(ch1);
            int x1 = fir[0], y1 = fir[1];
            first = Math.abs(x - x1) + Math.abs(y - y1) + calc(map, s.charAt(i), ch2, i+1, s, dp);
        }

        if(ch2 == '#') {
            second = calc(map, ch1, s.charAt(i), i + 1, s, dp);
        } else {
            int[] sec = map.get(ch2);
            int x2 = sec[0], y2 = sec[1];
            second = Math.abs(x - x2) + Math.abs(y - y2) + calc(map, ch1, s.charAt(i), i+1, s, dp);
        }

        return dp[a][b][i] = Math.min(first, second);
    }

    public int minimumDistance(String word) {
        int n = word.length();

        Map<Character, int[]> map = new HashMap<>();

        char ch = 'A';
        for(int i = 0; i < 4; ++ i) {
            for(int j = 0; j < 6; ++ j) {
                map.put(ch++, new int[]{i, j});
            }
        }

        map.put(ch++, new int[]{4, 0});
        map.put(ch++, new int[]{4, 1});
        
        int[][][] dp = new int[27][27][n];
        for(int[][] i: dp) for(int[] j: i) Arrays.fill(j, -1);

        return calc(map, '#', '#', 0, word, dp);
    }
}