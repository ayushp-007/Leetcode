class Solution {
    Double[][] dp;
    public double soupServings(int n) {
        if(n > 4451) return 1.0;
        n = (n + 24) / 25;
        dp = new Double[n + 1][n + 1];
        return recur(n, n);
    }
    public double recur(int a, int b) {
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1.0;
        if(b <= 0) return 0.0; 
        if(dp[a][b] != null) return dp[a][b];
        dp[a][b] = 0.25 * (recur(a - 4, b) + recur(a - 3, b - 1) + recur(a - 2, b - 2) + recur(a - 1, b - 3));
        return dp[a][b];
    }

}