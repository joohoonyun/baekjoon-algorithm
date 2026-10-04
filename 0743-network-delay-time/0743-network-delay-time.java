class Solution {
    class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    List<Node>[] graph;
    int[] visited;

    public int networkDelayTime(int[][] times, int n, int k) {
        // 다익스트라
        initGraph(n+1);

        for (int i=0; i<times.length; ++i) {
            int[] cur = times[i];
            graph[cur[0]].add(new Node(cur[1], cur[2]));
        }

        dijsktra(k);

        int max = 0;
        for (int i=1; i<=n; ++i) {
            if (visited[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, visited[i]);        
        }

        return max;
    }

    public void dijsktra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.cost));
        pq.offer(new Node(start, 0));

        visited[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int curCost = current.cost;
            int curVertex = current.to;

            if (curCost > visited[curVertex]) continue;

            for (Node next : graph[curVertex]) {
                int nextVertex = next.to;
                int nextCost = next.cost;

                int sumCost = curCost + nextCost;

                if (sumCost < visited[nextVertex]) {
                    visited[nextVertex] = sumCost;
                    pq.offer(new Node(nextVertex, sumCost));
                }
            }
        }
    }

    private void initGraph(int size) {
        graph = new ArrayList[size];
        visited = new int[size];
        Arrays.fill(visited, Integer.MAX_VALUE);

        for (int i=0; i<size; ++i) {
            graph[i] = new ArrayList<Node>();
        }
    }
}