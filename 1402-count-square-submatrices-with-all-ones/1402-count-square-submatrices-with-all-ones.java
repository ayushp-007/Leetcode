import static java.lang.Math.*;
class Solution {
    public int countSquares(int[][] matrix) {
        int cnt = 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 1) {
                    a[i][j] = 1;
                    cnt++;
                }
                if(i > 0 && j > 0 && matrix[i][j] == 1) {
                    int x = a[i - 1][j];
                    int y = a[i][j - 1];
                    int z = a[i - 1][j - 1];
                    a[i][j] = min(x, min(y, z)) + 1;
                    if(a[i][j] > 0) cnt += a[i][j] - 1;
                }
            }
        }
        // for(var i : a) System.out.println(Arrays.toString(i));
        return cnt;
    }
}