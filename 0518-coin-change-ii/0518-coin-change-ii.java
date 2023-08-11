class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[amount + 1][n];
        return count(n-1, amount, coins, dp);
    }
    public int count(int idx, int amount, int[] coins, Integer[][] dp) {
        if(idx == 0) return amount%coins[0] == 0 ? 1 : 0;
        if(dp[amount][idx] != null) return dp[amount][idx];
        int take = 0, not_take = 0;
        not_take = count(idx - 1, amount, coins, dp);
        if(amount >= coins[idx]) take = count(idx , amount - coins[idx], coins, dp);
        dp[amount][idx] = take + not_take;
        return dp[amount][idx];
    }
}