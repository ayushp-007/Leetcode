class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        int[] a = new int[n * m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[m*i+j] = grid[i][j];
            }
        }

        Arrays.sort(a);

        int median = a[(n*m) / 2];
        int cnt = 0;

        for (int i : a) {
            if (Math.abs(i - median) % x != 0) {
                return -1;
            }
            cnt += Math.abs(i - median) / x;
        }

        return cnt;
    }
}