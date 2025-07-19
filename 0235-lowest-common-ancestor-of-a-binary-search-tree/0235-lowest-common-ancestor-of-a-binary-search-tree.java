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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root==null || p==null ||q==null){
            return null;
         }
        if(Math.max(p.val,q.val) < root.val){
            //deciding wheather to go left subtree or right subtree as it is a BST (left<root<right)
            return lowestCommonAncestor(root.left, p, q);
        }else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

        //O(logn) as we are pruning the tree, we are discarding half of tree each time Or O(h) height of tree ( which is also logn)
    }

    //SPace Optimized O(1) , using Iterations instead of recursion
    // TreeNode cur = root;
        
    //     while (cur != null) {
    //         if (p.val > cur.val && q.val > cur.val) {
    //             cur = cur.right;
    //         } else if (p.val < cur.val && q.val < cur.val) {
    //             cur = cur.left;
    //         } else {
    //             return cur;
    //         }
    //     }
    //     return null;
}