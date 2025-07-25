/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
//Perform DFS on a starting node and then recursively call dfs on it's neighbours and at each step, save it to handle duplicacy
// if the node is in hashMap , we will return the value node from hashMap
//TC: O(V+E) , SC: O(V)
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);

    }
    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if (node == null) {
            return null;
        }

        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, oldToNew));
        }

        return copy;
    }
}