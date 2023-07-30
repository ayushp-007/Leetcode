import static java.lang.Math.*;
class Solution {
    Integer[][] dp;
    public int strangePrinter(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        dp = new Integer[n][n];
        return recur(0, n - 1, c);
    }
    public int recur(int i, int j, char[] c) {
        if(dp[i][j] != null) return dp[i][j];
        if(i == j) return 1;
        int ans = 0;
        if(c[i] == c[j] || c[j - 1] == c[j]) ans = recur(i, j - 1, c);
        else if(c[i] == c[i + 1]) ans = recur(i + 1, j, c);
        else {
            ans = recur(i, j - 1, c) + 1;
            for(int k = i + 1; k < j; k++) {
                if(c[k] == c[j]) {
                    ans = min(ans, recur(i, k - 1, c) + recur(k, j - 1, c));
                }
            }
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}