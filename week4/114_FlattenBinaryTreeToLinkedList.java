/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    private TreeNode helper(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        if (root.left == null) {
            return helper(root.right);
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return helper(root.right);
        }
        
        TreeNode lastLeft = helper(root.left);
        TreeNode lastRight = helper(root.right);
        
        lastLeft.right = root.right;
        root.right = root.left;
        root.left = null;
        return lastRight;
    }
}