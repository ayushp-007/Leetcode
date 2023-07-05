import static java.lang.Math.*;
class Solution {
    public int longestSubarray(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i : nums) sb.append(i);
        String[] s = sb.toString().split("0");
        System.out.println(Arrays.toString(s));
        if(s.length == 1) return s[0].length() == 1 ? 1 : s[0].length() - 1;
        int ans = 0;
        for(int i = 0; i<s.length - 1; i++) {
            if(!s[i].equals("")) ans = max(ans, s[i].length());
            if(!s[i + 1].equals("")) ans = max(ans, s[i + 1].length());
            if(!s[i].equals("") && !s[i + 1].equals("")) {
                ans = max(ans, s[i].length() + s[i + 1].length());
            }
        }
        return ans;
    }
}