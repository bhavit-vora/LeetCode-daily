/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

class Trie {
    Trie[] trie = new Trie[10];
    boolean flag = false;
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;

        Trie root = new Trie();

        for(int n: arr1) {
            Trie temp = root;
            List<Integer> digits = new ArrayList<>();
            while(n > 0) {
                digits.add(n % 10);
                n /= 10;
            }

            for(int i = digits.size() - 1; i >= 0; i --) {
                int idx = digits.get(i);
                if(temp.trie[idx] == null) temp.trie[idx] = new Trie();
                temp = temp.trie[idx];
                temp.flag = true;
            }
        }

        for(int n: arr2) {
            Trie temp = root;
            List<Integer> digits = new ArrayList<>();
            while(n > 0) {
                digits.add(n % 10);
                n /= 10;
            }

            for(int i = digits.size() - 1; i >= 0; i --) {
                int idx = digits.get(i);
                if(temp.trie[idx] == null) temp.trie[idx] = new Trie();
                temp = temp.trie[idx];
                if(temp.flag) ans = Math.max(ans, digits.size() - i);
            }
        }

        return ans;
    }
}