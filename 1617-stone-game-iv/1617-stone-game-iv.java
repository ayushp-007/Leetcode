class Solution {
    Boolean[][] dp;
    public boolean winnerSquareGame(int n) {
        dp = new Boolean[2][n + 1];
        return recur(0, n);
    }
    public boolean recur(int i, int n) {
        if(n == 0) return i == 1 ? true : false;
        if(dp[i][n] != null) return dp[i][n];
        boolean ans;
        if(i == 0) {
            ans = false;
            for(int j = 1; j * j <=n; j++) {
                ans |= recur(1 - i, n - j * j);
            }
        }
        else {
            ans = true;
            for(int j = 1; j * j <=n; j++) {
                ans &= recur(1 - i, n - j * j);
            }
        }
        dp[i][n] = ans;
        return dp[i][n];
    }
}