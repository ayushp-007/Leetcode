import static java.lang.Math.*;
class Solution {
    int cnt = 0;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0 , -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !vis[i][j]){
                    cnt = 0;
                    dfs(i, j, n, m, grid, vis);
                    ans = max(ans, cnt);
                }
            }
        }
        return ans;
    }
    public void dfs(int i, int j, int n, int m, int[][] grid, boolean[][] vis) {
        vis[i][j] = true;
        cnt++;
        for(var d : dir) {
            int x = i + d[0], y = j + d[1];
            if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1 && !vis[x][y]) 
                dfs(x, y, n, m, grid, vis);
        }
    }
}