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
    public int maxDepth(TreeNode root) {
        int max = 0;
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        // while(root.left!=null || root.right !=null){
        //     if(root.left!=null){
        //         root = root.left;
        //         max
        //     }
        // }
        max = helper(root,max);

        return max;
    }

    public int helper(TreeNode root, int m){
        if(root.left==null && root.right==null){
            return m+1;
        }
        if(root.left==null){
            return helper(root.right, m+1);
        }
        if(root.right==null){
            return helper(root.left, m+1);
        }
        return Math.max(helper(root.left,m+1), helper(root.right,m+1));
    }
}