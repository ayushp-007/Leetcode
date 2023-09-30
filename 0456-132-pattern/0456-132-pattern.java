import static java.lang.Math.*;
class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> st = new Stack<>();
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            while(!st.isEmpty() && nums[i] >= st.peek()[0]) st.pop();
            if(!st.isEmpty() && nums[i] > st.peek()[1]) return true;
            st.add(new int[]{nums[i], min});
            min = min(min, nums[i]);
        }
        return false;
    }
}