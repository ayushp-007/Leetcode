class Solution {
    public int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] != 0) return -1;
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;
        if(grid[0][1] <= 1) {
            q.add(new int[]{0, 1, 2});
            q.add(new int[]{1, 0, grid[1][0] + (grid[1][0] % 2 == 1 ? 1 : 2)});
            vis[0][1] = true;
            vis[1][0] = true;
        }
        if(grid[1][0] <= 1) {
            q.add(new int[]{1, 0, 2});
            q.add(new int[]{0, 1, grid[0][1] + (grid[0][1] % 2 == 1 ? 1 : 2)});
            vis[0][1] = true;
            vis[1][0] = true;
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.peek()[1];
            int t = q.poll()[2];
            if(i == n-1 && j == m-1) return t - 1;
            for(int[] d : dir){
                int x = i + d[0];
                int y = j + d[1];
                if(x >= 0 && x < n && y >= 0 && y < m && !vis[x][y]){
                    if(grid[x][y] <= t) q.add(new int[]{x, y, t+1});
                    else q.add(new int[]{x, y, grid[x][y] + (t % 2 == grid[x][y] % 2 ? 1 : 2)});
                    vis[x][y] = true;
                }  
            }
        }
        return -1;
    }
}

