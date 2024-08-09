class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(n < 3 || m < 3) return 0;
        int ans = 0;
        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < m - 1; j++) {
                int mask = 0;
                boolean ok = true;
                for(int k = -1; k <= 1; k++) {
                    for(int l = -1; l <= 1; l++) {
                        if(grid[i + k][j + 1] == 0 || grid[i + k][j + l] > 9)  {
                            ok = false;
                            break;
                        }
                        mask |= 1 << (grid[i + k][j + l] - 1);
                    }
                }
                if(!ok) continue;
                if(mask != ((1 << 9) - 1)) continue;
                int sum1 = grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1];
                int sum2 = grid[i][j - 1] + grid[i][j] + grid[i][j + 1];
                int sum3 = grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1];
                int sum4 = grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1];
                int sum5 = grid[i - 1][j] + grid[i][j] + grid[i + 1][j];
                int sum6 = grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1];
                int sum7 = grid[i - 1][j - 1] + grid[i][j] + grid[i + 1][j + 1];
                int sum8 = grid[i + 1][j - 1] + grid[i][j] + grid[i - 1][j + 1];
                if(sum1 == sum2 && sum2 == sum3 && sum3 == sum4 && sum4 == sum5 && sum5 == sum6 && sum6 == sum7 && sum7 == sum8 && sum8 == sum1) ans++;
            }
        }
        return ans;
    }
}