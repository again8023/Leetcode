/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        while (root == null || root.left == null) {  //corner case for null root
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;  //recursion
        root.left.right = root;
        root.left = null;   //very important.
        root.right = null;  //Ensure that the original root becoms the leaf node
        return newRoot;

    }
}
