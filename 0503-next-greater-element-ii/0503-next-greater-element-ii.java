import static java.lang.Math.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE, idx = -1;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++) {
            if(nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        Stack<Integer> st = new Stack<>();
        for(int i = idx; i>=0; i--) {
            if(st.isEmpty()) ans[i] = -1;
            else if(st.peek() > nums[i]) ans[i] = st.peek();
            else {
                while(!st.isEmpty() && st.peek() <= nums[i]) st.pop();
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.add(nums[i]);
        }
        for(int i = n - 1; i > idx; i--) {
            if(st.isEmpty()) ans[i] = -1;
            else if(st.peek() > nums[i]) ans[i] = st.peek();
            else {
                while(!st.isEmpty() && st.peek() <= nums[i]) st.pop();
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.add(nums[i]);
        }
        return ans;
    }
}