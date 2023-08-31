import static java.lang.Math.*;
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] a = new int[n + 1];
        for(int i = 0; i<=n; i++) a[i] = i;
        for(int i = 0; i<=n; i++) a[max(i - ranges[i], 0)] = min(i + ranges[i], n);
        int cnt = 0, curr = 0, nxt = 0;
        for(int i = 0; i < n; i++) {
            if(i > curr) return -1;
            nxt = max(nxt, a[i]);
            if(i == curr) {
                curr = nxt;
                cnt++;
            }
        }
        if(n > curr) return -1;
        return cnt;
    }
}