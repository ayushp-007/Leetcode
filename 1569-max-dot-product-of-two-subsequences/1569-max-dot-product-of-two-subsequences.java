import static java.lang.Math.*;
class Solution {
    Integer[][][] dp;
    int n, m;
    int[] a, b;
    final int inf = (int)(1e9);
    public int maxDotProduct(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        this.a = nums1;
        this.b = nums2;
        dp = new Integer[n][m][2];
        return recur(0, 0, 0);
    }
    public int recur(int i, int j, int k) {
        if(i == n || j == m) {
            if(k == 1) return 0;
            return -inf;
        }
        if(dp[i][j][k] != null) return dp[i][j][k];
        int ans = -inf;
        ans = max(ans, a[i] * b[j] + recur(i + 1, j + 1, 1));
        ans = max(ans, recur(i + 1, j, k));
        ans = max(ans, recur(i, j + 1, k));
        return dp[i][j][k] = ans;
    }
}