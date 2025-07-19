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
    // For every node, the difference between the height of its left and right subtrees is at most 1.
    // Also, both left and right subtrees must themselves be balanced.

    // 1️⃣ Use a recursive helper function checkHeight:
    // Returns the height of the subtree if it's balanced.
    // Returns -1 if any subtree is unbalanced.

    // 2️⃣ For each node:
    // Recursively calculate left and right subtree heights.
    // If any subtree returns -1, propagate -1 upwards.
    // If |leftHeight - rightHeight| > 1, mark as unbalanced.

    // 3️⃣ If root returns -1, the tree is unbalanced; else it's balanced.

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Helper method to check the height of the tree.
    // Returns -1 if the subtree is unbalanced.
    private int checkHeight(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1)
            return -1; // Left subtree is not balanced.

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1)
            return -1; // Right subtree is not balanced.

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1; // Current node is unbalanced.

        return 1 + Math.max(leftHeight, rightHeight); // Return height if balanced.
    }
}
