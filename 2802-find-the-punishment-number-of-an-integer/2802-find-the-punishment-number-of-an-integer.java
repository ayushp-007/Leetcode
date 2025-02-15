class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i = 1; i<=n; i++) if(good(i,0, ""+(i*i))) ans += i*i;
        return ans;
    }
    public boolean good(int i, int idx, String s) {
        if(idx == s.length() && i == 0) return true;
        if(idx == s.length() || i < 0 ) return false;
        for(int j = idx + 1; j<=s.length(); j++) {
            int t = Integer.valueOf(s.substring(idx, idx + j - idx));
            if(good(i - t, j, s)) return true;
        }
        return false;
        
    }
}