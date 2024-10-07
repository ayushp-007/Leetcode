class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(st.isEmpty()) st.add(c);
            else if((st.peek() == 'A' && c == 'B') || (st.peek() == 'C' && c == 'D')) st.pop();
            else st.add(c);
        }
        return st.size();
    }
}