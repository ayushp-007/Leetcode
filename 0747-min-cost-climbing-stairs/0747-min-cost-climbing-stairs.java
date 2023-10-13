import static java.lang.Math.*;
class Solution {
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new Integer[cost.length];
        return min(recur(0,cost), recur(1, cost));
    }
    public int recur(int i, int[] cost) {
        if(i >= cost.length) return 0;
        if(dp[i] != null) return dp[i];
        return dp[i] = cost[i] + min(recur(i + 1, cost), recur(i + 2, cost));
    }
}