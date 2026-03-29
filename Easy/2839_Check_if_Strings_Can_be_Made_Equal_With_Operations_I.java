/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int n = s1.length();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i += 2) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
            if(map.containsKey(ch1) && map.get(ch1) == 0) map.remove(ch1);
            if(map.containsKey(ch2) && map.get(ch2) == 0) map.remove(ch2);
        }

        if(map.size() != 0) return false;
        
        for(int i = 1; i < n; i += 2) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
            if(map.containsKey(ch1) && map.get(ch1) == 0) map.remove(ch1);
            if(map.containsKey(ch2) && map.get(ch2) == 0) map.remove(ch2);
        }

        if(map.size() != 0) return false;
        return true;
    }
}