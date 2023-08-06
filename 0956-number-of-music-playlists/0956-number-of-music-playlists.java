import static java.lang.Math.*;
class Solution {
    Long[][] dp;
    long mod = (long)(1e9 + 7);
    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new Long[n + 1][goal + 1];
        return (int)(recur(n, goal, k));
    }
    public long recur(int n, int goal, int k) {
        if(n == 0 && goal == 0) return 1L;
        if(n == 0 || goal == 0) return 0;
        if(dp[n][goal] != null) return dp[n][goal];
        long take = recur(n - 1, goal - 1, k) * n;
        long not_take = recur(n, goal - 1, k) * max(n - k, 0);
        dp[n][goal] = (take + not_take) % mod;
        return dp[n][goal];
    }
}