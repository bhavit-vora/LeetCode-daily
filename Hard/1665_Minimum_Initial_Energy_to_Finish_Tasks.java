/*
    TC: O(n * logn)
    SC: O(1)
*/

import java.util.*;

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> Integer.compare(b[1] - b[0], a[1] - a[0]));
        int ans = 0;
        int temp = 0;

        for(int[] i: tasks) {
            ans += Math.max(0, i[1] - temp);
            temp += i[1] > temp? i[1] - temp: 0;
            temp -= i[0];
        }

        return ans;
    }
}