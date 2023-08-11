class Solution {
    public int removePalindromeSub(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while(i < j) if(c[i++] != c[j--]) return 2;
        return 1;
    }
}