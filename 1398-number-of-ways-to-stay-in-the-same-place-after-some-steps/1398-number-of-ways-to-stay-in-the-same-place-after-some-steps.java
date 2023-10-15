class Solution {
    int MOD = (int)(1e9 + 7);
    Map<String, Long> dp;
    public int numWays(int steps, int arrLen) {
        dp = new HashMap<>();
        return (int)recur(steps, 0, arrLen);
    }
    public long recur(int i, int j, int k) {
        if(i == 0) {
            if(j == 0) return 1;
            return 0;
        }
        String key = i + "#" + j;
        if(dp.containsKey(key)) return dp.get(key);
        long ans = 0;
        if(j - 1 >= 0) {
            ans += recur(i - 1, j - 1, k);
            ans %= MOD;
        }
        if(j + 1 < k) {
            ans += recur(i - 1, j + 1, k);
            ans += MOD;
        }
        ans += recur(i - 1, j, k);
        ans %= MOD;
        dp.put(key, ans);
        return ans;
    }
}