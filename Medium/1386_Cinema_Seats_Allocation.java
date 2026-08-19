/*
    TC: O(n)
    SC: O(n)
    n -> seats.length
*/

import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] seats) {
        Arrays.sort(seats, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int c = 0;

        int prev = 0;
        int i = 0;
        while(i < seats.length) {
            int j = i;
            int row = seats[i][0];
            c += (2 * (row - prev - 1));

            Set<Integer> set = new HashSet<>();
            while(j < seats.length && seats[j][0] == row) set.add(seats[j++][1]);

            if(!(set.contains(2) || set.contains(3) || set.contains(4) || set.contains(5) || set.contains(6) || set.contains(7) || set.contains(8) || set.contains(9))) c += 2;
            else if(!(set.contains(2) || set.contains(3) || set.contains(4) || set.contains(5))) c++;
            else if(!(set.contains(4) || set.contains(5) || set.contains(6) || set.contains(7))) c++;
            else if(!(set.contains(6) || set.contains(7) || set.contains(8) || set.contains(9))) c++;
            prev = row;
            i = j;
        }

        c += (2 * (n - prev));

        return c;
    }
}