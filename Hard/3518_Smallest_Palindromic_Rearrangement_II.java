/*
    TC: O(n ^ 2)
    SC: O(n)
*/

class Solution {

    public int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public int count(int[] freq, int len, int limit) {
        int ans = 1;

        int rem = len;
        for (int i = 0; i < 26; i++) {
            int count = freq[i];

            for (int j = 1; j <= count; j++) {
                int numerator = rem - count + j;

                int g = gcd(numerator, j);
                numerator /= g;
                int denominator = j / g;

                g = gcd(ans, denominator);
                ans /= g;
                denominator /= g;

                if (ans > limit / numerator) {
                    return limit;
                }

                ans *= numerator;

                if (ans >= limit) {
                    return limit;
                }
            }

            rem -= count;
        }

        return ans;
    }

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        
        for(int i = 0; i < n / 2; ++ i) freq[s.charAt(i) - 'a']++;

        int len = n / 2;

        StringBuilder ans = new StringBuilder();
        while(len > 0) {
            boolean f = false;

            for(int i = 0; i < 26; ++ i) {
                if(freq[i] == 0) continue;

                freq[i]--;
                int res = count(freq, len - 1, k);

                if(res >= k) {
                    f = true;
                    ans.append((char)('a' + i));
                    break;
                }
            
                k -= res;
                freq[i]++;
            }

            len--;
            if(!f) return "";
        }

        for(int i = 25; i >= 0; -- i) {
            while(freq[i]-- > 0) ans.append((char)('a' + i));
        }

        String c = "";
        if(n % 2 == 1) c = String.valueOf(s.charAt(n / 2));

        return ans.toString() + c + ans.reverse().toString();
    }
}