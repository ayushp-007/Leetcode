class Solution {
    public int longestPalindrome(String s) {
        int[] a = new int[58];
        for(char c : s.toCharArray()) a[c - 'A']++;
        int ans = 0, chk = 0;
        for(int i : a) {
            if(i % 2 == 0) ans += i;
            else {
                ans += i - 1;
                chk = 1;
            }
        }
        return ans + chk;
    }
}