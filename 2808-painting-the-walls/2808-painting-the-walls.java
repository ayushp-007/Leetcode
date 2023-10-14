import static java.lang.Math.*;
class Solution {
    Integer[][] dp;
    int inf = (int)1e9;
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        dp = new Integer[n][n + 1];
        return recur(0, n, cost, time);
    }
    public int recur(int i, int n, int[] cost, int[] time) {
        if(n <= 0) return 0;
        if(i >= cost.length) return inf;
        if(dp[i][n] != null) return dp[i][n];
        int take = cost[i] + recur(i + 1, n - time[i] - 1, cost, time);
        int not_take = recur(i + 1, n, cost, time);
        return dp[i][n] = min(take, not_take);
    }
}