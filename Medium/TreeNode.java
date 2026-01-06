/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.offer(root);
        int idx = 0;
        int max = Integer.MIN_VALUE;
        int level = -1;

        while(!q.isEmpty()) {
            idx++;
            int sum = 0;
            int size = q.size();

            for(int i = 0; i < size; i ++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }

            if(sum > max) {
                level = idx;
                max = sum;
            }
        }

        return level;
    }
}