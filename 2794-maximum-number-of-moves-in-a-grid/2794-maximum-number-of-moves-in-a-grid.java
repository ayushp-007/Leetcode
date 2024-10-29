import static java.lang.Math.*;
class Solution {
    int n, m;
    Integer[][] dp;
    public int maxMoves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) max = max(max, dfs(i, 0, grid));
        return max - 1;
    }
    
    public int dfs(int i, int j, int[][] grid) {
        if(dp[i][j] != null) return dp[i][j];
        int ans = 1;
        if(i > 0 && j < m - 1 && grid[i - 1][j + 1] > grid[i][j]) ans = max(ans, dfs(i-1, j+1, grid) + 1);
        if(j < m - 1 && grid[i][j + 1] > grid[i][j]) ans = max(ans, dfs(i, j+1, grid) + 1);
        if(i < n-1 && j < m - 1 && grid[i + 1][j + 1] > grid[i][j]) ans = max(ans, dfs(i+1, j+1, grid) + 1);
        dp[i][j] = ans;
        return dp[i][j];
    }
    
}