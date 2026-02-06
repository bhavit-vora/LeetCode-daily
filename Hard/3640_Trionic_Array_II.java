/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

// Approach 1

class Solution {
    int n;
    long[][] memo;
    static final long NEG_INF = Long.MIN_VALUE / 2;

    long solve(int i, int trend, int[] nums) {
        if (i == n) {
            return (trend == 3) ? 0 : NEG_INF;
        }

        if (memo[i][trend] != Long.MIN_VALUE) {
            return memo[i][trend];
        }

        long take = NEG_INF;
        long skip = NEG_INF;

        if (trend == 0) {
            skip = solve(i + 1, 0, nums);
        }

        if (trend == 3) {
            take = nums[i];
        }

        if (i + 1 < n) {
            int curr = nums[i];
            int next = nums[i + 1];

            if (trend == 0 && next > curr) {
                take = Math.max(take, curr + solve(i + 1, 1, nums));
            } 
            else if (trend == 1) {
                if (next > curr) {
                    take = Math.max(take, curr + solve(i + 1, 1, nums));
                } else if (next < curr) {
                    take = Math.max(take, curr + solve(i + 1, 2, nums));
                }
            } 
            else if (trend == 2) {
                if (next < curr) {
                    take = Math.max(take, curr + solve(i + 1, 2, nums));
                } else if (next > curr) {
                    take = Math.max(take, curr + solve(i + 1, 3, nums));
                }
            } 
            else if (trend == 3 && next > curr) {
                take = Math.max(take, curr + solve(i + 1, 3, nums));
            }
        }

        return memo[i][trend] = Math.max(take, skip);
    }

    public long maxSumTrionic(int[] nums) {
        n = nums.length;
        memo = new long[n][4];

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Long.MIN_VALUE);
        }

        return solve(0, 0, nums);
    }
}

// Approach 2

class Solution2 {
    public long helper(int[] nums, int i, boolean ok) {
        if(i == -1 || i == nums.length) return -10_000_000_000_000L;
        if(ok) {
            if(nums[i] >= nums[i+1]) return -10_000_000_000_000L;
            if(nums[i] < 0 && nums[i] < nums[i+1]) return nums[i];
            long sum = 0l;
            while(i >= 0 && nums[i] >= 0 && nums[i] < nums[i+1]) sum += nums[i--];
            return sum;
        } else {
            if(nums[i] <= nums[i-1]) return -10_000_000_000_000L;
            long sum = nums[i++];
            long temp = sum;
            while(i < nums.length && nums[i] > nums[i-1]) {
                temp += nums[i];
                sum = Math.max(sum, temp);
                i++;
            }
            return sum;
        }
    }

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE / 2000;

        int l = 0;
        while(l < n) {
            int r = l + 1;
            long sum = nums[l];
            while(r < n && nums[r] < nums[r-1]) sum += nums[r++];

            if(r != l + 1) {
                long left = helper(nums, l-1, true);
                long right = helper(nums, r, false);
                if(left != -10_000_000_000_000L && 
                   right != -10_000_000_000_000L) 
                     if(sum + left + right > max) {
                        max = Math.max(max, sum + left + right);
                        System.out.println(l);
                     }
            }

            l = r;
        }

        return max;
    }
}