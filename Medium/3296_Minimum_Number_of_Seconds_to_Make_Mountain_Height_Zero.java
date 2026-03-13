/*
    TC: O(50 * n)
    Sc: O(1)
*/

class Solution {
    public boolean possible(int h, int[] time, long mid) {
        int n = time.length;
        
        for(int i = 0; i < n; ++ i) {
            h -= (int)((-1 + Math.sqrt(1 + 8 * mid / time[i])) / 2);
            if(h <= 0) return true;
        }

        return false;
    }

    public long minNumberOfSeconds(int height, int[] time) {

        long low = 0, high = (long)1e16;

        while(low <= high) {
            long mid = (low + high) / 2;

            if(possible(height, time, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}