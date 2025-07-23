public class Solution {
    private boolean[] visit;
    private List<List<Integer>> adj;
    private Set<Integer> cycle;
    private int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        //Create a Adjacency List of Graph Given
        //Also Keep track of cycles and visited nodes
        // We're checking if a given undirected graph is a valid tree by:
        // Ensuring it's connected (all nodes are visited from node 0),
        // And has no cycles (using DFS while skipping the parent node).
        // If all nodes are visited and no cycles are found → it's a valid tree.
        // Both O(V+E)
        int n = edges.length;
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) 
            adj.add(new ArrayList<>());
 
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visit = new boolean[n + 1];
        cycle = new HashSet<>();
        cycleStart = -1;
        //DFS on Node,Parent
        dfs(1, -1);

        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0], v = edges[i][1];
            if (cycle.contains(u) && cycle.contains(v)) {
                return new int[]{u, v};
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int par) {
        if (visit[node]) {
            cycleStart = node;
            return true;
        }
        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == par) continue;
            //node and neighbour swapped and again did dfs
            if (dfs(nei, node)) {
                if (cycleStart != -1) cycle.add(node);
                if (node == cycleStart) {
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}