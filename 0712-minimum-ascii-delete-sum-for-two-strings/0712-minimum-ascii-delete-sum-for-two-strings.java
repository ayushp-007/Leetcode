import static java.lang.Math.*;
class Solution {
    Integer[][] dp;
    int inf = (int)(1e7);
    int[] pre1, pre2;
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int n = c1.length, m = c2.length;
        pre1 = new int[n];
        pre2 = new int[m];
        pre1[0] = c1[0];
        pre2[0] = c2[0];
        for(int i = 1; i<n; i++) pre1[i] = pre1[i - 1] + c1[i];
        for(int i = 1; i<m; i++) pre2[i] = pre2[i - 1] + c2[i]; 
        dp = new Integer[n][m];
        return recur(0, 0, c1, c2);
    }
    public int recur(int i, int j, char[] a, char[] b) {
        if(i == a.length && j == b.length) return 0;
        if(i == a.length) return pre2[b.length - 1] - pre2[j] + b[j];
        if(j == b.length) return pre1[a.length - 1] - pre1[i] + a[i];
        if(dp[i][j] != null) return dp[i][j];
        int ans = inf;
        if(a[i] == b[j]) ans = min(ans, recur(i + 1, j + 1, a, b));
        else {
            ans = min(ans, a[i] + recur(i + 1, j, a, b));
            ans = min(ans, b[j] + recur(i, j + 1, a, b));
        } 
        dp[i][j] = ans;
        return dp[i][j];
    }
}