class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        for(int[] i : ans) Arrays.fill(i, 10001);
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j, 0});
                    ans[i][j] = 0;
                }
            }
        }
        int[][] dir = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        while(!q.isEmpty()){
            int[] t = q.poll();
            int i = t[0];
            int j = t[1];
            int dis = t[2];
            for(int[] d : dir){
                int x = i + d[0];
                int y = j + d[1];
                if(x < 0 || x >= n || y < 0 || y >= m) continue;
                if(dis + 1 < ans[x][y]){
                    ans[x][y] = dis + 1;
                    q.add(new int[]{x, y, dis+1});
                }
            }
        }
        return ans;
    }
}