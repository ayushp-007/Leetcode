import static java.lang.Math.*;
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<i; j++) {
                if(check(words[i], words[j]) && dp[j] + 1 > dp[i]) dp[i] = 1 + dp[j];
            }
            max = max(max, dp[i]);
        }
        return max;
    }
    public boolean check(String A, String B) {
        char[] a = A.toCharArray(), b = B.toCharArray();
        int n = a.length, m = b.length, i = 0, j = 0;
        if(n != m + 1) return false;
        while(i < n) {
            if(j < m && a[i] == b[j]) {
                i++;
                j++;
            } 
            else {
                i++;
            }
        }
        return i == n && j == m;
    }
}