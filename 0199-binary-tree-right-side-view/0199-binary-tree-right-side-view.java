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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //BFS
        //Do BFS with ArrayDeque / Queue -> only add the rightmost in queue to answer list and repeat bfs as it is
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        if(root==null){
            return ans;
        }
        q.addFirst(root);
        while(!q.isEmpty()){
            int s = q.size();
            while(s>0){
                TreeNode node = q.removeFirst();
                if(s==1){
                    ans.add(node.val);
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                                if(node.right!=null){
                    q.add(node.right);
                }
                s--;
            }
        }

        return ans;
        
    }
}