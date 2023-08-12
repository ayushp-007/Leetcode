import static java.lang.Math.*;
class Solution {
    Integer[][] dp;
    int[] a;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        a = new int[m + 2];
        dp = new Integer[m + 2][m + 2];
        for(int i = 0; i<m; i++) a[i + 1] = cuts[i];
        a[m + 1] = n;
        Arrays.sort(a);
        return recur(1, m);
    }
    public int recur(int i, int j) {
        if(i > j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int ans = (int)(1e9);
        for(int k = i; k <= j; k++) {
            int cut = a[j + 1] - a[i - 1] + recur(i, k - 1) + recur(k + 1, j);
            ans = min(ans, cut);
        }
        return dp[i][j] = ans;
    }
}