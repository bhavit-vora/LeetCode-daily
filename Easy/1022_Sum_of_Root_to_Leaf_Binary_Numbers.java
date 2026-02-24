/*
    TC: O(n)
    SC: O(n)
*/

import Utils.TreeNode;

class Solution {
    public int ans;

    public void dfs(TreeNode root, int sum) {
        if(root == null) {
            return;
        }

        sum <<= 1;
        sum |= root.val;

        if(root.left == null && root.right == null) {
            ans += sum;
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
        sum >>= 1;
    }

    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }
}