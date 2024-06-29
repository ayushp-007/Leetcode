class Solution {
    List<Integer>[] adj;
    List<List<Integer>> ans;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ans = new ArrayList<>();
        adj = new List[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            ans.add(new ArrayList<>());
        }
        for(int [] i : edges) {
            adj[i[0]].add(i[1]);
        }
        for(int i = 0; i < n; i++) dfs(i, i, new boolean[n]);
        for(int i = 0; i < n; i++) Collections.sort(ans.get(i));
        return ans;
    }
    public void dfs(int curr, int node, boolean[] vis) {
        vis[node] = true;
        for(int i : adj[node]) {
            if(!vis[i]) {
                ans.get(i).add(curr);
                dfs(curr, i, vis);
            }
        }
    }
}