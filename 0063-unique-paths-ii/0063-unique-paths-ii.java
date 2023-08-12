class Solution {
    Integer[][] dp = new Integer[101][101];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(n == 1 && m == 1){
            if(obstacleGrid[0][0] == 0) return 1;
            else return 0;
        }
        if(obstacleGrid[0][0] == 1) return 0;
        return dfs(obstacleGrid, 0, 0, n, m);
    }
    public int dfs(int[][] grid, int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 1) return 0;
        if(i == n-1 && j == m-1) return 1;
        if(dp[i][j] != null) return dp[i][j];
        grid[i][j] = 1;
        int total = dfs(grid, i, j+1, n, m) + dfs(grid, i+1, j, n, m);
        grid[i][j] = 0;
        dp[i][j] = total;
        return dp[i][j];
    }
}