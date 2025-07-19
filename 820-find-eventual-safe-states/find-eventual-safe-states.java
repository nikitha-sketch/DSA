class Solution {
    public boolean dfs(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis, check) == true)
                    return true;
            } else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        check[node] = 1;  // Mark as safe
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert input graph (adjacency matrix) to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}
