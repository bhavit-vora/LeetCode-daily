/*
    TC: O(q * l + n * l)
    SC: O(q * l)
*/

import java.util.*;

class Trie {
    Trie[] trie = new Trie[26];
    boolean isEnd = false;
}

class Solution {
    Trie root;

    public void insert(Trie root, int i, String word) {
        if(i == word.length()) {
            root.isEnd = true;
            return;
        }

        int idx = word.charAt(i) - 'a';
        if(root.trie[idx] == null) root.trie[idx] = new Trie();
        insert(root.trie[idx], i+1, word);
    }

    public boolean check(Trie root, int i, String word, int wrongCount) {
        if(i == word.length()) return true;

        int idx = word.charAt(i) - 'a';
        if(wrongCount < 2) {
            for(int ii = 0; ii < 26; ii ++) {
                if(root.trie[ii] != null && check(root.trie[ii], i+1, word, wrongCount+1)) return true;
            }
        }

        if(root.trie[idx] != null) {
            if(check(root.trie[idx], i+1, word, wrongCount)) return true;
        }

        return false;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        root = new Trie();
        for(String s: dictionary) {
            insert(root, 0, s);
        }

        List<String> ans = new ArrayList<>();
        for(String s: queries) {
            if(check(root, 0, s, 0)) {
                ans.add(s);
            }
        }

        return ans;
    }
}