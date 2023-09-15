class Solution {
    Map<String, Boolean> map;
    public boolean isScramble(String s1, String s2) {
        map = new HashMap<>();
        return recur(s1, s2);
    }
    public boolean recur(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() <= 1) return false;
        String key = s1 + "#" + s2;
        if(map.containsKey(key)) return map.get(key);
        int n = s1.length();
        boolean ans = false;
        for(int i = 1; i<n; i++) {
            boolean a = recur(s1.substring(0, i), s2.substring(0, i)) && recur(s1.substring(i), s2.substring(i));
            boolean b = recur(s1.substring(0, i), s2.substring(n - i)) && recur(s1.substring(i), s2.substring(0, n - i));
            if(a || b) {
                ans = true;
                break;
            }
        }
        map.put(key, ans);
        return ans;
    }
}