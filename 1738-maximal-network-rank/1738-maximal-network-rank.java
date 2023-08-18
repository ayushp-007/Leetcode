import static java.lang.Math.*;
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] adj = new Set[n];
        for(int i = 0; i<n; i++) adj[i] = new HashSet<>();
        for(var i : roads) {
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
        }
        int ans = 0;
        for(int i = 0; i<n; i++) {
            for(int j = i + 1; j < n; j++) {
                ans = max(ans, adj[i].size() + adj[j].size() - (adj[i].contains(j) ? 1 : 0));
            }
        }
        return ans;
    }
}