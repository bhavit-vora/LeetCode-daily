/*
    TC: O(2 * n)
    SC: O(n)
*/

import java.util.*;
import Utils.*;

class Solution {
    public static final int MOD = 1_000_000_007;
    private long ans;

    public int dfs(TreeNode root) { // calculates the sum of every sub-tree
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        return root.val += left + right;
    }

    public int maxProduct(TreeNode root) {
        ans = 0l;
        int total = dfs(root);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) { // finds maximum value after split
            TreeNode curr = q.poll();
            int first = curr.val;
            int second = total - first;
            long val = 1l * first * second;
            ans = Math.max(ans, val);

            if(curr.left != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);
        }

        return (int)(ans % MOD);
    }
}