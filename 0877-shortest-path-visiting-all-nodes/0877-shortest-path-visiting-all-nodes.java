import static java.lang.Math.*;
class Solution {
    int key;
    Integer[][] dp;
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        key = (1 << n) - 1;
        dp = new Integer[n][(1 << n)];
        int[][] dis = new int[n][n];
        for(var i : dis) Arrays.fill(i, (int)(1e9));
        for(int i = 0; i < n; i++) {
            dis[i][i] = 0;
            for(int j : graph[i]) dis[i][j] = dis[j][i] = 1;
        }
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        // for(var i : dis) System.out.println(Arrays.toString(i));
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            ans = min(ans, dfs(i, 0, dis));
        }
        return ans;
    }
    public int dfs(int node, int mask, int[][] dis) {
        if(mask == key) return 0;
        if(dp[node][mask] != null) return dp[node][mask];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < dis.length; i++) {
            if(((mask >> i) & 1) == 0) {
                mask |= (1 << i);
                ans = min(ans, dfs(i, mask, dis) + dis[node][i]);
                mask &= ~(1 << i);
            }
        }
        dp[node][mask] = ans;
        return ans;
    }
}