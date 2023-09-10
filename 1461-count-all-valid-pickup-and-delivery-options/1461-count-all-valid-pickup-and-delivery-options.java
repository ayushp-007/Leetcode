class Solution {
    public int countOrders(int n) {
        long ans = 1, mod = (long)(1e9 + 7);
        for(long i = 2; i<=n; i++) ans = (i % mod * (2 * i - 1) % mod * ans % mod) % mod;
        return (int)ans;
    }
}