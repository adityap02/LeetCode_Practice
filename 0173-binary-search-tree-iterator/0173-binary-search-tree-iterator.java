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
class BSTIterator {
    TreeNode root; 
    PriorityQueue<Integer> pq;
    public BSTIterator(TreeNode root) {
        this.root=root;
        pq = new PriorityQueue<Integer>();
        addNumbersToQueue(pq, root);

    }
    
    public int next() {
        return pq.poll();
    }
    
    public boolean hasNext() {
        return !pq.isEmpty();
    }

    public void addNumbersToQueue(PriorityQueue<Integer> queue, TreeNode root) {
        if(root == null)
            return;
        
        queue.add(root.val);
        addNumbersToQueue(queue, root.left);
        addNumbersToQueue(queue, root.right); // simple dfs to add all values in heap. 
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */