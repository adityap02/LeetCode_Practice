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
    //O(MN) => N node in the tree, we check if the tree rooted at node is identical to subRoot. This check takes O(M) time, where M is the number of nodes in subRoot.
    //Extension of isSameTree Question
    //Used method of isSmaeTree and used herw ith recursion
    //for each node in Tree , will check if the subtree with that node is same as subroot ?
    //if yes return true else check same with recursion on left & right Subtree
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        } else if ((isSameTree(root.left, subRoot)) || (isSameTree(root.right, subRoot))
                || (isSameTree(root, subRoot))) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //Recursion on same Method
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}