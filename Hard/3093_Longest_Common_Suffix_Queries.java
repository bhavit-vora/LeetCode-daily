/*
    TC: O(n + q)
    SC: O(n + q)
    n -> words.length
    q -> queries.length
*/

class Solution {

    class Trie {
        Trie[] trie = new Trie[26];
        int idx = -1;
    }

    public int[] stringIndices(String[] words, String[] queries) {
        int q = queries.length;
        int[] ans = new int[q];

        Trie root = new Trie();
        root.idx = 0;

        for(int ii = 0; ii < words.length; ++ ii) {
            Trie temp = root;
            String s = words[ii];
            int n = s.length();
            if(s.length() < words[temp.idx].length()) temp.idx = ii;

            for(int i = n - 1; i >= 0; -- i) {
                int idx = s.charAt(i) - 'a';
                if(temp.trie[idx] == null) temp.trie[idx] = new Trie();
                if(temp.trie[idx].idx == -1) temp.trie[idx].idx = ii;
                if(words[temp.trie[idx].idx].length() > s.length()) temp.trie[idx].idx = ii;
                temp = temp.trie[idx];
            }
        }

        for(int ii = 0; ii < q; ++ ii) {
            Trie temp = root;
            String s = queries[ii];
            int n = s.length();

            for(int i = n - 1; i >= 0; -- i) {
                int idx = s.charAt(i) - 'a';
                if(temp.trie[idx] != null) temp = temp.trie[idx];
                else break;
            }

            ans[ii] = temp.idx;
        }

        return ans;
    }
}