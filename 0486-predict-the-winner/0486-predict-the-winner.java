import static java.lang.Math.*;
class Solution {
    Integer[][] dp;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n];
        return recur(0, n - 1, nums) >= 0;
    }
    public int recur(int i, int j, int[] nums) {
        if(i == j) return nums[j];
        if(dp[i][j] != null) return dp[i][j];
        int left = nums[i] - recur(i + 1, j, nums);
        int right = nums[j] - recur(i, j - 1, nums);
        dp[i][j] = max(left, right);
        return dp[i][j];
    }
}