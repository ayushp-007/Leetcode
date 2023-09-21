class MinStack {
    Stack<Integer> st;
    TreeMap<Integer, Integer> map;
    public MinStack() {
        st = new Stack<>();
        map = new TreeMap<>();
    }
    
    public void push(int val) {
        st.add(val);
        map.merge(val, 1, Integer :: sum);
    }
    
    public void pop() {
        int t = st.pop();
        map.merge(t, -1, Integer :: sum);
        if(map.get(t) == 0) map.remove(t);
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return map.firstKey();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */