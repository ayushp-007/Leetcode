class Solution {
    public boolean buddyStrings(String s, String goal) {
        char[] a = s.toCharArray(), b = goal.toCharArray();
        int[] f1 = new int[26], f2 = new int[26];
        for(var i : a) f1[i-'a']++;
        for(var i : b) f2[i-'a']++;
        if(!Arrays.equals(f1, f2)) return false;
        boolean two = false;
        int cnt = 0;
        for(int i = 0; i<a.length; i++) {
            if(a[i] != b[i]) cnt++;
            if(f2[b[i]-'a'] >= 2) two = true;
        }
        if(cnt == 0) return two;
        return cnt == 2;
    }
}