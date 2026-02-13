/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {

    public int count1(String s) {
        int ans = 0;
        int i = 0;
        int n = s.length();
        while(i < n) {
            char ch = s.charAt(i);
            int cnt = 0;

            while(i < n && s.charAt(i) == ch) {
                cnt++;
                i++;
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public int count2(String s, char a, char b) {
        int n = s.length();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cnt = 0;
        int ans = 0;

        for(int i = 0; i < n; i ++) {
            if(s.charAt(i) == a) {
                cnt ++;
            } else if(s.charAt(i) == b) {
                cnt --;
            } else {
                map = new HashMap<>();
                map.put(0, i);
                cnt = 0;
            }

            if(map.containsKey(cnt)) {
                ans = Math.max(ans, i - map.get(cnt));
            } else {
                map.put(cnt, i);
            }
        }

        return ans;
    }

    public int count3(String s) {
        int n = s.length();
        int ans = 0;
        Map<Long, Integer> map = new HashMap<>();

        int a = 0, b = 0, c = 0;
        map.put(0l, -1);

        for(int i = 0; i < n; i ++) {
            char ch = s.charAt(i);
            if(ch == 'a') a++;
            else if(ch == 'b') b++;
            else c++;

            if(a == b && b == c) ans = Math.max(ans, a + b + c);

            int diffAB = a - b;
            int diffAC = a - c;

            long d = ((long)diffAB << 32) | (diffAC & 0xffffffffL);

            if(map.containsKey(d)) {
                ans = Math.max(ans, i - map.get(d));
            } else {
                map.put(d, i);
            }
        }

        return ans;
    }

    public int longestBalanced(String s) {
        int ans = count1(s);
        ans = Math.max(ans, count2(s, 'a', 'b'));
        ans = Math.max(ans, count2(s, 'a', 'c'));
        ans = Math.max(ans, count2(s, 'c', 'b'));
        ans = Math.max(ans, count3(s));

        return ans;
    }
}