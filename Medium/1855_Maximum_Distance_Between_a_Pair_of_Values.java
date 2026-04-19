/*
    TC: O(n + m)
    SC: O(1)
*/

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        int ans = 0;
        int p1 = n - 1, p2 = m - 1;
        while(p1 >= 0 && p2 >= 0) {
            if(p1 > p2) {
                p1--;
                continue;
            } if(nums2[p2] < nums1[p1]) {
                p2--;
                continue;
            }

            ans = Math.max(ans, p2 - p1);
            p1--;
        }
        
        return ans;
    }
}