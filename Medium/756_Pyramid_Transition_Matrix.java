/*
    TC: O(n ^ 2 + a ^ n) approx
    SC: O(a + 6 * n + 6 ^ n)
    a = allowed.length;
    n = bottom.length;
*/

import java.util.*;

class Solution {
    public void generate(int i, List<List<Character>> total, List<String> ans, String temp) {
        if(i == total.size()) {
            ans.add(temp);
            return;
        }

        for(char ch: total.get(i)) {
            generate(i+1, total, ans, temp + ch);
        }
    }

    public boolean helper(String curr, Map<String, List<Character>> map) {
        if(curr.length() == 1) return true;

        List<List<Character>> total = new ArrayList<>();
        for(int i = 0; i < curr.length() - 1; i ++) {
            if(map.containsKey(curr.substring(i, i+2))) {
                List<Character> l = map.get(curr.substring(i, i+2));
                total.add(l);
            } else {
                return false;
            }
        }

        List<String> next = new ArrayList<>();
        generate(0, total, next, "");

        for(String s: next) {
            if(helper(s, map)) return true;
        }

        return false;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for(String s: allowed) {
            char ch = s.charAt(2);
            s = s.substring(0, 2);
            List<Character> l = map.getOrDefault(s, new ArrayList<>());
            l.add(ch);
            map.put(s, l);
        }

        return helper(bottom, map);
    }
}