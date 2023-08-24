import static java.lang.Math.*;
class Solution {
    int n, m;
    Integer[][] dp;
    int[][] dir = {{1, 0}, {0, 1}};
    public int calculateMinimumHP(int[][] dungeon) {
        n = dungeon.length;
        m = dungeon[0].length;
        dp = new Integer[n][m];
        return recur(0, 0, dungeon);
    }
    public int recur(int i, int j, int[][] a) {
        if(i == n-1 && j == m-1) return a[i][j] > 0 ? 1 : 1 - a[i][j];
        if(dp[i][j] != null) return dp[i][j];
        int ans = (int)(1e9);
        for(var d : dir) {
            int x = i + d[0], y = j + d[1];
            if(x >= 0 && x < n && y >= 0 && y < m) {
                ans = min(ans, recur(x, y, a));
            }
        }
        return dp[i][j] = ans - a[i][j] > 0? ans - a[i][j] : 1;
    }
}