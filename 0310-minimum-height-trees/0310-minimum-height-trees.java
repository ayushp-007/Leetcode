class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        List<Integer>[] adj = new List[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<>();
        for(var i : edges) {
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
            degree[i[0]]++;
            degree[i[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++) if(degree[i] == 1) q.add(i);
        while(!q.isEmpty()) {
            ans.clear();
            int t = q.size();
            while(t-->0) {
                int node = q.poll();
                ans.add(node);
                for(int i : adj[node]) {
                    degree[i]--;
                    if(degree[i] == 1) q.add(i);
                }
            }
        }
        return ans;
    }
}