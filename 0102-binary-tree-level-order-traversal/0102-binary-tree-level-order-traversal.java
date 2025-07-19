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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        //BFS
        //ArrayDeque<TreeNode> q= new ArrayDeque<>(); Cant use arrayDeque because cant keep null in it
         Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int num = q.size();
            while(num>0){
                TreeNode node = q.poll();
                if(node!=null){
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
                num--;
            }
            if(level.size()>0){
                ans.add(level);
            }
        }

        return ans;
    }


}