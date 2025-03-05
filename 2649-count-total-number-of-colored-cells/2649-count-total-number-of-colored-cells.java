class Solution {
    public long coloredCells(int n) {
        long[] color = new long[n];
        color[0] = 1;
        for(int i = 1; i<n; i++){
            color[i] = color[i-1] + 4*i;
        }
        return color[n-1];
    }
}