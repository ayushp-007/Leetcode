class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.merge(c, 1, Integer :: sum);
        int ans = 0, check = 0;
        for(int i : map.values()) {
            if(i % 2 == 0) ans += i;
            else  {
                ans += i - 1;
                check = 1;
            }
        }
        return ans + check;
    }
}