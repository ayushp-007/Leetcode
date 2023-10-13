class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        dp = [None] * n
        def recur(i):
            if i >= n:
                return 0
            if dp[i] != None:
                return dp[i]
            dp[i] = cost[i] + min(recur(i + 1), recur(i + 2))
            return dp[i]
        return min(recur(0), recur(1))
