/*
    TC: O(1)
    SC: O(1)
*/

import java.util.*;

class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long val = 0;
        List<Integer> l = new ArrayList<>();
        while(n > 0) {
            int num = n % 10;
            sum += num;
            if(num != 0) l.add(num);
            n /= 10;
        }

        for(int i=l.size()-1;i>=0;i--) val = val * 10 + l.get(i);

        return val * sum;
    }
}