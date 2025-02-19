import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] conn : connections) {
            graph.get(conn[0]).add(new int[]{conn[1], 1}); // Original direction
            graph.get(conn[1]).add(new int[]{conn[0], 0}); // Reverse direction
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 0;

        for (int[] neighbor : graph.get(node)) {
            int nextNode = neighbor[0], isOriginal = neighbor[1];

            if (!visited[nextNode]) {
                count += isOriginal + dfs(nextNode, graph, visited);
            }
        }
        return count;
    }
}
