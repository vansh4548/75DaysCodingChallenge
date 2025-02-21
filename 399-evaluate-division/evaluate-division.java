import java.util.*;

class Solution {
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0), y = queries.get(i).get(1);
            res[i] = dfs(x, y, new HashSet<>());
        }
        return res;
    }

    private double dfs(String src, String dest, Set<String> visited) {
        if (!graph.containsKey(src) || !graph.containsKey(dest)) return -1.0;
        if (src.equals(dest)) return 1.0;
        
        visited.add(src);
        for (Map.Entry<String, Double> neighbor : graph.get(src).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), dest, visited);
                if (result != -1.0) return result * neighbor.getValue();
            }
        }
        return -1.0;
    }
}
