class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int n = grid.length;
        int[] f = new int[n*n + 1];
        for(var i : grid) for(var j : i) f[j]++;
        for(int i = 1; i <= n * n; i++) {
            if(f[i] == 2) ans[0] = i;
            if(f[i] == 0) ans[1] = i;
        }
        return ans;
    }
}