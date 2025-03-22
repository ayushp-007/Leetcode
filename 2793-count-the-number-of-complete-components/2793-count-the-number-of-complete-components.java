class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Set<Integer>[]  adj = new Set[n];
        for(int i = 0; i<n; i++) adj[i] = new HashSet<>();
        for(int[] i : edges){
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
        }
        boolean[] vis = new boolean[n];
        int ans = 0;
        
        for(int i = 0; i<n; i++) {
            if(!vis[i]) {
                ans++;
                List<Integer> list = new ArrayList<>();
                
                dfs(i, adj, vis, list);
                boolean b = false;
                for(int j = 0; j<list.size(); j++) {
                    for(int k = j+1; k<list.size(); k++) {
                        int u = list.get(j), v = list.get(k);
                        
                        if(!adj[u].contains(v)) {
                            b = true;
                            break;
                        }
                    }
                }
                if(b) ans--;
            }
        }
        return ans;
    }
    public void dfs(int node, Set<Integer>[] adj, boolean[] vis, List<Integer> list) {
        vis[node] = true;
        list.add(node);
        for(int i : adj[node]) {
            if(!vis[i]) dfs(i, adj, vis, list);
        }
    }
}