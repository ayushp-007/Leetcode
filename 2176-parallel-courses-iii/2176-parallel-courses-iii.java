import static java.lang.Math.*;
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(var i : relations) {
            int u = i[0] - 1, v = i[1] - 1;
            indegree[v]++;
            adj[u].add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[n];
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i : adj[node]) {
                indegree[i]--;
                vis[i] = max(vis[i], vis[node] + time[node]);
                if(indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = max(ans, vis[i] + time[i]);
        }
        return ans;
    }
}