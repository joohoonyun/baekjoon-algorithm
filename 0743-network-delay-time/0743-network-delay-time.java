class Solution {
    class Node {
        int cost;
        int vertex;

        public Node(int cost, int vertex) {
            this.cost = cost;
            this.vertex = vertex;
        }
    }
    
    List<Node>[] graph;
    int[] visited;

    public int networkDelayTime(int[][] times, int n, int k) {
        initGraph(times, n);
        visited = new int[n+1];
        dijkstra(times, n, k);

        int max = 0;
        for (int i=1; i<=n; ++i) {
            if (visited[i] == Integer.MAX_VALUE) return -1;

            int current = visited[i];
            max = Math.max(max, current);
        }
        return max;
    }

    public void initGraph(int[][] times, int n) {
        graph = new ArrayList[n+1];
        for (int i=0; i<n+1; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<times.length; ++i) {
            int[] current = times[i];
            int from = current[0];
            int to = current[1];
            int cost = current[2];

            graph[from].add(new Node(cost, to));
        }
    }

    public void dijkstra(int[][] times, int n, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.cost));
        pq.offer(new Node(0, k));
        
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[k] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int currentCost = now.cost;
            int currentVertex = now.vertex;

            if (currentCost > visited[currentVertex]) continue;
            for (Node next : graph[currentVertex]) { // k = start
                int nextCost = next.cost;
                int nextVertex = next.vertex;

                int sumCost = nextCost + currentCost;
                if (sumCost < visited[nextVertex]) {
                    visited[nextVertex] = sumCost;
                    pq.offer(new Node(sumCost, nextVertex));
                }
            }
        }       
    }
}