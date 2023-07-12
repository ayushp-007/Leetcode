class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] safe = new int[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer>[] adj = new List[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            for(int j : graph[i]) adj[j].add(i);
            safe[i] = graph[i].length;
            if(safe[i] == 0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i : adj[node]) {
                safe[i]--;
                if(safe[i] == 0) q.add(i);
            }
        }
        for(int i = 0; i<n; i++) if(safe[i] == 0) ans.add(i);
        return ans; 
    }
}