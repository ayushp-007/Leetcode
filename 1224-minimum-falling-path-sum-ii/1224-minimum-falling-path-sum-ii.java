import static java.lang.Math.*;
class Solution {
    Integer[][] dp;
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        dp = new Integer[n][n];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++) ans = min(ans, recur(0, i, n, grid));
        return ans;
    }
    public int recur(int i, int j, int n, int[][] a) {
        if(i == n - 1) return a[i][j];
        if(dp[i][j] != null) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = 0; k < n; k++) {
            if(k == j) continue;
            ans = min(ans, recur(i + 1, k, n, a));
        }
        return dp[i][j] = a[i][j] + ans;
    }
}