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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> postOrder = new ArrayList<Integer>();
        
        if (root == null) {
            return postOrder;
        }
        
        s.push(root);
        TreeNode preOutPut = null;
        while (!s.empty()) {
            TreeNode cur = s.peek();
            if ((cur.left == null && cur.right == null) || 
                (preOutPut != null) && (preOutPut == cur.left || preOutPut == cur.right)) {
                postOrder.add(cur.val);
                preOutPut = s.pop();
            } else {
                if (cur.right != null) {
                    s.push(cur.right);
                } 
                if (cur.left != null) {
                    s.push(cur.left);
                }
            }
        }
        return postOrder;
    }
}