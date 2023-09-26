class Solution {
    public String removeDuplicateLetters(String s) {
        char[] c = s.toCharArray();
        int[] idx = new int[26];
        boolean[] vis = new boolean[26];
        int n = c.length;
        for(int i = 0; i<n; i++) idx[c[i] - 'a'] = i;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++) {
            if(vis[c[i] - 'a']) continue;
            while(!st.isEmpty() && st.peek() > c[i] && i < idx[st.peek() - 'a']) {
                vis[st.pop() - 'a'] = false;
            }
            st.add(c[i]);
            vis[c[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}