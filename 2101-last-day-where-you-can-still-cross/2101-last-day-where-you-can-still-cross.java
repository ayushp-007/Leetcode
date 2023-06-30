class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0, high = cells.length, ans = 0;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(check(mid, row, col, cells)) {
                low = mid + 1;
                ans = mid;
            }
            else {
                high = mid;
            }
        }
        return ans;
    }
    public boolean check(int mid, int n, int m, int[][] cells) {
        int[][] a = new int[n][m];
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i<mid; i++) a[cells[i][0] - 1][cells[i][1] - 1] = 1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i<m; i++) {
            if(a[0][i] == 0) {
                q.add(new int[]{0, i});
                vis[0][i] = true;
            }
        }
        while(!q.isEmpty()) {
            var v = q.poll();
            if(v[0] == n - 1) return true;
            for(var d : dir) {
                int i = v[0] + d[0], j = v[1] + d[1];
                if(i >= 0 && i < n && j >= 0 && j < m && a[i][j] != 1 && !vis[i][j]) {
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        return false;
    }
}