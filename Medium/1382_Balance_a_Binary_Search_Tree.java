/*
    TC: O(n)
    SC: O(n)
*/

import java.util.*;
import Utils.TreeNode;

class Solution {
    public void inOrder(TreeNode root, List<TreeNode> tree) {
        if(root == null) return;

        inOrder(root.left, tree);
        tree.add(root);
        inOrder(root.right, tree);
    }

    public TreeNode build(List<TreeNode> tree, int low, int high) {
        if(low > high) return null;

        int mid = (low + high) / 2;
        tree.get(mid).left = build(tree, low, mid - 1);
        tree.get(mid).right = build(tree, mid + 1, high);

        return tree.get(mid);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> tree = new ArrayList<>();
        inOrder(root, tree);
        return build(tree, 0, tree.size()-1);
    }
}