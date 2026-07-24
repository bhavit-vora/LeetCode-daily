/*
    TC: O(n ^ 2)
    SC: O(1)
*/

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int[] set = new int[3000];
        int[] ans = new int[3000];
        for(int i: nums) {
            for(int j: nums) {
                set[i ^ j] = 1;
            }
        }

        int cnt = 0;

        for(int i: nums) {
            for(int j = 0; j < 1501; ++ j) {
                if(set[j] == 0) continue;
                if(ans[i ^ j] == 0) {
                    cnt++;
                    ans[i ^ j] = 1;
                }
            }
        }

        return cnt;
    }
}