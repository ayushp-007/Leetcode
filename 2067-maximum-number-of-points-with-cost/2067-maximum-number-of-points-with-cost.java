import static java.lang.Math.*;
class Solution {
    public long maxPoints(int[][] a) {
        int n = a.length, m = a[0].length;
        long[] prev = new long[m];
        for(int i = 0; i<m; i++) prev[i] = a[0][i];
        for(int i = 0; i<n - 1; i++) {
            long[] left = new long[m], right = new long[m], curr = new long[m];
            left[0] = prev[0];
            right[m - 1] = prev[m - 1];
            for(int j = 1; j<m; j++) left[j] = max(left[j - 1] - 1, prev[j]);
            for(int j = m - 2; j>=0; j--) right[j] = max(right[j + 1] - 1, prev[j]);
            for(int j = 0; j<m; j++) curr[j] = a[i + 1][j] + max(left[j], right[j]);
            prev = curr;
        }
        long ans = 0;
        for(var i : prev) ans = max(ans, i);
        return ans;
    }
}