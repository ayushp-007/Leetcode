class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt = 0;
        int n = grid1.length, m = grid1[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid1[i][j] == 1 && grid2[i][j] == 1 && !vis[i][j]) {
                    cnt += bfs(i, j, grid1, grid2, vis) ? 1 : 0;
                }
            }
        }
        return cnt;
    }
    public boolean bfs(int row, int col, int[][] a, int[][] b, boolean[][] vis) {
        int n = a.length, m = a[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        vis[row][col] = true;
        boolean ok = true;
        while(!q.isEmpty()) {
            var node = q.poll();
            for(var d : dir) {
                int i = node[0] + d[0], j = node[1] + d[1];
                if(i >=0 && i < n && j >= 0 && j < m ) {
                    if ( a[i][j] == 1 && b[i][j] == 1 && !vis[i][j] ) {    
                        vis[i][j] = true;
                        q.add(new int[]{i, j});
                    } else if(a[i][j] == 0 && b[i][j] == 1 && !vis[i][j]) {
                        ok = false;
                        vis[i][j] = true;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        return ok;
    }
}