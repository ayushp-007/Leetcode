import static java.lang.Math.*;
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int mx = 0, n = difficulty.length;
        for(int i : difficulty) mx = max(mx, i);
        int[] a = new int[mx + 1];
        for(int i = 0; i < n; i++) {
            a[difficulty[i]] = max(a[difficulty[i]], profit[i]);
        }
        for(int i = 1; i <= mx; i++) {
            a[i] = max(a[i - 1], a[i]);
        }
        int ans = 0;
        for(int i : worker) {
            if(i > mx) ans += a[mx];
            else ans += a[i];
        }
        return ans;
    }
}