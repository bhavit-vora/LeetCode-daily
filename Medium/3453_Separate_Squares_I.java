/*
    TC: O(n * logn)
    SC: O(1)
*/

class Solution {
    public boolean calculate(int[][] squares, double mid) {
        double area1 = 0.0, area2 = 0.0;

        for(int[] square: squares) {
            double y = square[1];
            double len = square[2];

            if(mid <= y) {
                area2 += len * len;
            } else if(mid >= y + len) {
                area1 += len * len;
            } else {
                area1 += len * (mid - y);
                area2 += len * (y + len - mid);
            }
        }

        return area1 >= area2;
    }
    public double separateSquares(int[][] squares) {
        double low = 0.0, high = 1e9;

        while(high - low > 1e-5) {
            double mid = (low + high) / 2.0;

            if(calculate(squares, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }
}