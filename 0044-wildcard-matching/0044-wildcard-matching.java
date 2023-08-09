class Solution {
    Boolean[][] dp;
    int n, m;
    char[] a, b;
    public boolean isMatch(String s, String p) {
        a = s.toCharArray();
        b = p.toCharArray();
        n = a.length;
        m = b.length;
        dp = new Boolean[n + 1][m + 1];
        return recur(0, 0);
    }
    public boolean recur(int i, int j) {
        if(i >= n && j >= m) return true;
        if(i > n || j >= m) return false;
        if(dp[i][j] != null) return dp[i][j];
        if(b[j] == '*') return dp[i][j] = recur(i + 1, j) | recur(i, j + 1);
        if(i < n && (a[i] == b[j] || b[j] == '?')) return dp[i][j] = recur(i + 1, j + 1);
        return dp[i][j] = false;
    }
}