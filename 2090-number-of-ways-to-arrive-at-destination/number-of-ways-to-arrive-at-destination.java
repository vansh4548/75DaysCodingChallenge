class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph=new HashMap<>();
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }

        long[] dist = new long[n]; 
        int[] ways = new int[n];   
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
   
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); 
        
        int MOD = 1_000_000_007;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];

            if (d > dist[node]) continue;

            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0], weight = neighbor[1];
                long newDist = dist[node] + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node]; 
                    pq.offer(new long[]{newDist, nextNode});
                } 
   
                else if (newDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];  
    }
}