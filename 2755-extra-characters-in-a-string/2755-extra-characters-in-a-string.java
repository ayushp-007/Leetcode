import static java.lang.Math.*;
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for(String st: dictionary) set.add(st);
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<=n; j++) {
                if(set.contains(s.substring(i, j))) dp[j] = min(dp[j], dp[i]);
            }
            dp[i+1] = min(dp[i+1], dp[i] + 1);
        }
        return dp[n];
    }
}