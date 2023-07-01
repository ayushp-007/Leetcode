import static java.lang.Math.*;
class Solution {
    int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] a = new int[k];
        helper(0, a, cookies);
        return ans;
    }
    public void helper(int idx, int[] a, int[] cookies) {
        if(idx == cookies.length) {
            int max = Integer.MIN_VALUE;
            for(var i : a) max = max(max, i);
            ans = min(ans, max);
            return;
        }
        for(int i = 0; i<a.length; i++) {
            a[i] += cookies[idx];
            helper(idx + 1, a, cookies);
            a[i] -= cookies[idx];
        }
    }
}