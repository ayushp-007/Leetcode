import static java.lang.Math.*;
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        Deque<int[]> q = new LinkedList<>();
        q.addLast(new int[]{0, -1});
        for(int i = 0; i < n; i++) {
            while(!q.isEmpty() && q.peekFirst()[1] < i - k) q.pollFirst();
            int t = max(q.peekFirst()[0], 0);
            dp[i] = nums[i] + t;
            while(!q.isEmpty() && q.peekLast()[0] < dp[i]) q.pollLast();
            q.addLast(new int[]{dp[i], i});
        }
        int ans = Integer.MIN_VALUE;
        for(int i : dp) ans = max(ans, i);
        return ans;
    }
}