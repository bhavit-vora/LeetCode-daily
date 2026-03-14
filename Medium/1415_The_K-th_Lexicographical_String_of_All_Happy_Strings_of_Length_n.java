/*
    TC: O(n * 2 ^ n)
    SC: O(n * 2 ^ n)
*/

import java.util.*;

class Solution {

    List<String> list;

    public void backtrack(int n, char c, StringBuilder temp) {
        if(n == 0) {
            list.add(new String(temp.toString()));
            return;
        }

        for(char ch = 'a'; ch <= 'c'; ++ ch) {
            if(c != ch) {
                temp.append(ch);
                backtrack(n-1, ch, temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public String getHappyString(int n, int k) {
        list = new ArrayList<>();
        backtrack(n, '.', new StringBuilder());

        return list.size() < k? "": list.get(k-1);
    }
}