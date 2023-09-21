class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if(board[i][j] == 'O') {
                        q.add(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()) {
            var v = q.poll();
            for(var d : dir) {
                int i = v[0] + d[0], j = v[1] + d[1];
                if(i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O' && !vis[i][j]) {
                    vis[i][j] = true;
                    q.add(new int[]{i, j});
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = vis[i][j] ? 'O' : 'X';
            }
        }
    }
}