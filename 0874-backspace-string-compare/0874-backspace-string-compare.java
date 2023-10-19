class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '#') {
                if(!st.isEmpty()) st.pop();
            }
            else st.add(c);
        }
        s = String.valueOf(st);
        st = new Stack<>();
        for(char c : t.toCharArray()) {
            if(c == '#') {
                if(!st.isEmpty()) st.pop();
            }
            else st.add(c);
        }
        t = String.valueOf(st);
        return s.equals(t);
    }
}