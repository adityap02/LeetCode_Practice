/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int diameter;
    //Diameter may or may not pass through the root.
    // DFS (longestPath) to compute the height of left and right subtrees for every node.
    //At each node, update the diameter as the sum of left and right heights + 2 
    //(which equals number of edges on the path through that node).
    //We use left + right + 2 because:
    //The base height is -1 (null), so for one edge we get 0 height.
    //+2 accounts for both connections from the current node to left and right subtrees.
    //Finally, return the global diameter after the full traversal.
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;

        longestPath(root);
        return diameter;
    }

    int longestPath(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        diameter = Math.max(diameter, leftPath + rightPath + 2);
        return Math.max(leftPath, rightPath) + 1;
    }
}