class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] a = str1.toCharArray(), b = str2.toCharArray();
        if(b.length > a.length) return false;
        int i = 0, j = 0;
        for(; i<a.length && j < b.length; i++) {
            if(a[i] == b[j]) j++;
            else {
                if(a[i] == 'z') {
                    if('a' == b[j]) j++;
                }
                else {
                    if((char)(a[i] + 1) == b[j]) j++;
                }
            }
        }
        return j == b.length;
    }
}