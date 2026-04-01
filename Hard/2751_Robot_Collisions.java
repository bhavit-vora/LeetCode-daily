/*
    TC: O(n * logn)
    SC: O(n)
*/

import java.util.*;

class Solution {
    class Robo {
        int idx;
        int p, h;
        char dir;

        Robo(int idx, int p, int h, char dir) {
            this.p = p;
            this.h = h;
            this.idx = idx;
            this.dir = dir;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        int n = positions.length;

        List<Robo> list = new ArrayList<>();

        for(int i = 0; i < n; ++ i) {
            list.add(new Robo(i, positions[i], healths[i], directions.charAt(i)));
        }

        Collections.sort(list, (a, b) -> Integer.compare(a.p, b.p));
        Stack<Robo> st = new Stack<>();

        for(Robo robo: list) {
            boolean flag = true;
            while(!st.isEmpty() && st.peek().dir == 'R' && robo.dir == 'L') {
                if(st.peek().h == robo.h) {
                    st.pop();
                    flag = false;
                    break;
                } else if(st.peek().h < robo.h) {
                    st.pop();
                    robo.h--;
                } else {
                    st.peek().h--;
                    flag = false;
                    break;
                }
            }

            if(flag) st.push(robo);
        }

        List<Robo> ans = new ArrayList<>();
        while(!st.isEmpty()) {
            ans.add(st.pop());
        }

        Collections.sort(ans, (a, b) -> Integer.compare(a.idx, b.idx));

        List<Integer> res = new ArrayList<>();
        for(Robo robo: ans) res.add(robo.h);
        return res;
    }
}