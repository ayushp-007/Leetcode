class Solution {
public:
    int recur(int i, vector<int>& cost, int* dp) {
        if(i >= cost.size()) return 0;
        if(dp[i] != -1) return dp[i];
        return dp[i] = cost[i] + min(recur(i + 1, cost, dp), recur(i + 2, cost, dp));
    }
    int minCostClimbingStairs(vector<int>& cost) {
        int dp[cost.size()];
        memset(dp, -1, sizeof(dp));
        return min(recur(0, cost, dp), recur(1, cost, dp)); 
    }
};