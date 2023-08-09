import static java.lang.Math.*;
class Solution {
    Integer[][] dp;
    int n, m;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        dp = new Integer[n][m];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                ans = max(ans, recur(i, j, matrix));
            }
        }
        return ans;
    }
    public int recur(int i, int j, int[][] a) {
        if(dp[i][j] != null) return dp[i][j];
        int ans = 0;
        for(var d : dir) {
            int x = i + d[0], y = j + d[1];
            if(x >= 0 && x < n && y >= 0 && y < m && a[x][y] > a[i][j]) {
                ans = max(ans, recur(x, y, a));
            }
        }
        return dp[i][j] = 1 + ans;
    }
}