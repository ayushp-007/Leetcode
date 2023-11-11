class Graph {
    List<int[]>[] adj;
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new List[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<>();
        for(int[] i : edges) adj[i[0]].add(new int[]{i[1], i[2]});
    }
    
    public void addEdge(int[] edge) {
        adj[edge[0]].add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[node1] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        q.add(new int[]{node1, 0});
        while(!q.isEmpty()) {
            int node = q.peek()[0];
            int dist = q.poll()[1];
            for(int[] i : adj[node]) {
                if(dis[node] + i[1] < dis[i[0]]) {
                    dis[i[0]] = dis[node] + i[1];
                    q.add(new int[]{i[0], dis[i[0]]});
                }
            }
        }
        if(dis[node2] == Integer.MAX_VALUE) return -1;
        return dis[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */