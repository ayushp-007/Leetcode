import static java.lang.Math.*;
class Solution {
    public int longestValidParentheses(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] a = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(c[i] == '(') st.add(i);
            else {
                if(!st.isEmpty()) {
                    a[i] = 1;
                    a[st.pop()] = 1;
                }
            }
        }
        int cnt = 0, ans = 0;
        for(int i : a) {
            if(i == 1) cnt++;
            else cnt = 0;
            ans = max(ans, cnt);
        }
        return ans;
    }
}