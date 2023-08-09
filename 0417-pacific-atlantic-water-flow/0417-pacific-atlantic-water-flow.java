class Solution {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int n, m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        boolean[][] pacific = new boolean[n][m], atlantic = new boolean[n][m];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(i == 0 || j == 0) dfs(i, j, pacific, heights);
                if(i == n - 1 || j == m - 1) dfs(i, j, atlantic, heights);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    public void dfs(int i, int j, boolean[][] vis, int[][] a) {
        vis[i][j] = true;
        for(var d : dir) {
            int x = i + d[0], y = j + d[1];
            if(x >= 0 && x < n && y >= 0 && y < m && !vis[x][y] && a[x][y] >= a[i][j]) {
                dfs(x, y, vis, a);
            }
        }
    }
}