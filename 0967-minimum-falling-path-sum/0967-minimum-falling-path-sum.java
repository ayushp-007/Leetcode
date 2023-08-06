import static java.lang.Math.*;
class Solution {
    Integer[][] dp;
    public int minFallingPathSum(int[][] a) {
        int n = a.length;
        dp = new Integer[n][n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) ans = min(ans, recur(0, i, n, a));
        return ans;
    }
    int recur(int i, int j, int n, int[][] a){
        if (dp[i][j] != null) return dp[i][j];
        if (i == n-1) return dp[i][j] = a[i][j];
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (j > 0) left = recur(i + 1, j - 1, n, a);
        int straight = recur(i + 1, j, n, a);
        if (j < n-1) right = recur(i + 1, j + 1, n, a);
        return dp[i][j] = min(left, min(straight, right)) + a[i][j];
    }
}