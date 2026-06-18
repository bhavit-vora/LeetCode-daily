/*
    TC: O(1)
    SC: O(1)
*/

class Solution {
    public double angleClock(int h, int m) {
        if(h == 12) h = 0;
        double angle = Math.max(m * 6, (double)h * 30 + m * 0.5) - Math.min(m * 6, (double)h * 30 + m * 0.5);
        return Math.min(angle, 360 - angle);
    }
}