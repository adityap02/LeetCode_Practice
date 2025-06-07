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
    int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return dfs(root,0);
    }

    boolean dfs(TreeNode root, int currSum){
        if(root==null){
            return false;
        }
        currSum= currSum+root.val;
        if(root.left==null && root.right ==null){
            return currSum==target;
        }

        
            
            return dfs(root.left,currSum) || dfs(root.right,currSum);


    }
}