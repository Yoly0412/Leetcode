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
    public int sumNumbers(TreeNode root) {
        int result = helper(root, 0);
        return result;
    }
    private int helper(TreeNode root, int pre) {
        if (root == null) {
            return 0;
        }
        
        int sum = root.val + pre * 10;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = helper(root.left, sum);
        int right = helper(root.right, sum);
        return left + right;
    }
}