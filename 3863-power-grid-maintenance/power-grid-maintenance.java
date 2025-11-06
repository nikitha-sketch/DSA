import java.util.*;

class Solution {

    // Simple Disjoint Set Union (Union-Find)
    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i; // each station is its own parent initially
            }
        }

        // Find the root (leader) of a station
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        // Join two stations (connect their grids)
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pb] = pa; // make pa the parent
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);

        // Step 1: Connect all given stations (build grids)
        for (int[] con : connections) {
            dsu.union(con[0], con[1]);
        }

        // Step 2: Create a map for each grid -> list of online stations
        Map<Integer, TreeSet<Integer>> gridOnline = new HashMap<>();

        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            gridOnline.putIfAbsent(root, new TreeSet<>());
        }

        // Initially all stations are online
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            gridOnline.get(root).add(i);
        }

        boolean[] offline = new boolean[c + 1]; // track offline stations
        List<Integer> result = new ArrayList<>();

        // Step 3: Process each query one by one
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int root = dsu.find(x);

            if (type == 1) {
                // Maintenance check
                if (!offline[x]) {
                    result.add(x); // station is online
                } else {
                    TreeSet<Integer> onlineStations = gridOnline.get(root);
                    if (onlineStations.isEmpty()) {
                        result.add(-1); // no online station in this grid
                    } else {
                        result.add(onlineStations.first()); // smallest online id
                    }
                }

            } else if (type == 2) {
                // Station goes offline
                if (!offline[x]) {
                    offline[x] = true;
                    gridOnline.get(root).remove(x); // remove from online list
                }
            }
        }

        // Convert List<Integer> to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    // Example main to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int c = 5;
        int[][] connections = {{1,2},{2,3},{3,4},{4,5}};
        int[][] queries = {{1,3},{2,1},{1,1},{2,2},{1,2}};
        System.out.println(Arrays.toString(sol.processQueries(c, connections, queries)));
        // Output: [3, 2, 3]
    }
}
