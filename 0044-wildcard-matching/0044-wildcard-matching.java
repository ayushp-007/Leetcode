class Solution {
    Boolean[][] dp;;
    public boolean isMatch(String s, String p) {
        char[] a = s.toCharArray();
        char[] b = p.toCharArray();
        int n = a.length;
        int m = b.length;
        dp = new Boolean[n + 1][m + 1];
        return recur(0, 0, n, m, a, b);
    }
    public boolean recur(int i, int j, int n, int m, char[] a, char[] b) {
        if(i >= n && j >= m) return true;
        if(i > n || j >= m) return false;
        if(dp[i][j] != null) return dp[i][j];
        if(b[j] == '*') return dp[i][j] = recur(i + 1, j, n, m, a, b) | recur(i, j + 1, n, m, a, b);
        if(i < n && (a[i] == b[j] || b[j] == '?')) return dp[i][j] = recur(i + 1, j + 1, n, m, a, b);
        return dp[i][j] = false;
    }
}