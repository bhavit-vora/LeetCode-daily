/*
    BFS: 
        TC: O(2 * n)
        SC: O(2 * n)
    DFS:
        TC: O(n)
        SC: O(2 * n)
*/

import java.util.*;
import Utils.TreeNode;

class Solution {

    private class Node {
        TreeNode node;
        int depth;
        Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // using DFS
    private Node dfs(TreeNode root, int depth) {
        if(root == null) return new Node(null, 0);

        Node left = dfs(root.left, depth + 1);
        Node right = dfs(root.right, depth + 1);

        if (left.depth > right.depth) {
            return new Node(left.node, left.depth + 1);
        } else if (right.depth > left.depth) {
            return new Node(right.node, right.depth + 1);
        } else {
            return new Node(root, left.depth + 1);
        }
    }

    // using BFS
    private TreeNode bfs(TreeNode root) {

        TreeNode[] par = new TreeNode[501];
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        par[root.val] = null;

        Set<TreeNode> set = new HashSet<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i ++) {
                TreeNode curr = q.poll();
                set.add(curr);
                if(curr.left != null) {
                    q.offer(curr.left);
                    par[curr.left.val] = curr;
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                    par[curr.right.val] = curr;
                }
            }

            if(q.size() > 0) set.clear();
        }

        while(set.size() > 1) {
            List<TreeNode> parents = new ArrayList<>();
            for(TreeNode i: set) {
                parents.add(par[i.val]);
            }

            set.clear();
            for(TreeNode i: parents) {
                set.add(i);
            }
        }

        for(TreeNode i: set) {
            return i;
        }

        return root;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode res = bfs(root);
        res = dfs(root, 0).node;
        return res;
    }
}