import static java.lang.Math.*;
class Solution {
    Integer[][] dp;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        dp = new Integer[n][n];
        int[] pre = new int[n];
        pre[0] = stones[0];
        for(int i = 1; i<n; i++) pre[i] = pre[i - 1] + stones[i];
        return recur(0, n - 1, stones, pre);
    }
    public int recur(int i, int j, int[] a, int[] pre) {
        if(i == j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        dp[i][j] = max(pre[j - 1] - pre[i] + a[i] - recur(i, j - 1, a, pre),pre[j] - pre[i + 1] + a[i + 1] - recur(i + 1, j, a, pre));
        return dp[i][j];
    }
}