/*
    TC: O(n * logn)
    SC: O(n)
*/

import java.util.*;

class Solution {

    class SegTree {
        int n;
        int[] covCnt;
        double[] covLen;
        int[] xs;

        SegTree(int[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            this.covCnt = new int[4 * n];
            this.covLen = new double[4 * n];
        }

        void update(int node, int left, int right, int ql, int qr, int delta) {
            if(qr <= left || right <= ql) return;

            if(ql <= left && qr >= right) {
                covCnt[node] += delta;
            } else {
                int mid = (left + right) / 2;
                update(node * 2, left, mid, ql, qr, delta);
                update(node * 2 + 1, mid, right, ql, qr, delta);
            }

            if(covCnt[node] > 0) {
                covLen[node] = xs[right] - xs[left];
            } else if(left + 1 == right) {
                covLen[node] = 0;
            } else {
                covLen[node] = covLen[node * 2] + covLen[node * 2 + 1];
            }
        }
    }

    public double separateSquares(int[][] squares) {
        List<int[]> events = new ArrayList<>();
        Set<Integer> xSet = new HashSet<>();

        for(int[] sq: squares) {
            int x = sq[0], y = sq[1], len = sq[2];
            events.add(new int[]{y, 1, x, len});
            events.add(new int[]{y+len, -1, x, len});
            xSet.add(x);
            xSet.add(x+len);
        }

        Collections.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int[] xs = xSet.stream().sorted().mapToInt(i -> i).toArray();
        Map<Integer, Integer> xIdx = new HashMap<>();
        for(int i = 0; i < xs.length; i ++) xIdx.put(xs[i], i);

        SegTree st = new SegTree(xs);
        double total = 0;
        int prev = events.get(0)[0];

        for(int[] e: events) {
            int curr = e[0];
            total += st.covLen[1] * (curr - prev);
            st.update(1, 0, st.n, xIdx.get(e[2]), xIdx.get(e[2] + e[3]), e[1]);
            prev = curr;
        }

        double half = total / 2;

        st = new SegTree(xs);
        double area = 0;
        prev = events.get(0)[0];

        for(int[] e: events) {
            int curr = e[0];
            double width = st.covLen[1];
            double dy = curr - prev;

            if(area + width * dy >= half) {
                return prev + (half - area) / width;
            }

            area += width * dy;
            st.update(1, 0, st.n, xIdx.get(e[2]), xIdx.get(e[2] + e[3]), e[1]);
            prev = curr;
        }

        return prev;
    }
}