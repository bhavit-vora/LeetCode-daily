/*
    TC: O(n * m)
    SC: O(n * m)
*/

import java.util.*;

class Solution {

    public boolean isSame(char[] arr, String str, int idx) {
        for(int i = 0; i < str.length(); ++ i) {
            if(str.charAt(i) != arr[idx++]) return false;
        }

        return true;
    }

    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] arr = new char[n + m - 1];
        boolean[] can = new boolean[n + m - 1];
        Arrays.fill(arr, '.');

        for(int i = 0; i < n; ++ i) {
            if(str1.charAt(i) == 'T') {
                for(int j = 0; j < m; ++ j) {
                    if(arr[i+j] != '.' && arr[i+j] != str2.charAt(j)) return "";
                    arr[i+j] = str2.charAt(j);
                }
            }
        }

        for(int i = 0; i < n + m - 1; ++ i) {
            if(arr[i] != '.') continue;
            arr[i] = 'a';
            can[i] = true;
        }

        for(int i = 0; i < n; ++ i) {
            if(str1.charAt(i) == 'F') {
                if(isSame(arr, str2, i)) {
                    boolean f = false;

                    for(int j = i + m - 1; j >= i; -- j) {
                        if(can[j]) {
                            arr[j] = 'b';
                            f = true;
                            break;
                        }
                    }

                    if(!f) return "";
                }
            }
        }

        return new String(arr);
    }
}