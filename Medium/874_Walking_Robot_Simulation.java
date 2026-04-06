/*
    TC: O(n + m)
    SC: O(m)
    m -> obstacles.length
*/

import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<>();

        for(int[] i: obstacles) {
            obs.add(i[0] + " " + i[1]);
        }

        int max = 0;

        int x = 0, y = 0, dir = 0;
        for(int dist: commands) {
            if(dist == -1) dir = (dir + 1) % 4;
            else if(dist == -2) dir = (dir + 3) % 4;
            else {
                for(int i = 0; i < dist; ++ i) {
                    if(dir == 0) {
                        if(obs.contains(x + " " + (y + 1))) break;
                        else y++;
                    } if(dir == 1) {
                        if(obs.contains((x + 1) + " " + y)) break;
                        else x++;
                    } if(dir == 2) {
                        if(obs.contains(x + " " + (y - 1))) break;
                        else y--;
                    } if(dir == 3) {
                        if(obs.contains((x - 1) + " " + y)) break;
                        else x--;
                    }
                }
            }

            max = Math.max(max, x * x + y * y);
        }

        return max;
    }
}