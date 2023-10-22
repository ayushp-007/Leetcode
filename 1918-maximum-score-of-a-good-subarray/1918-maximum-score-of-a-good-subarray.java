import static java.lang.Math.*;
class Solution {
    public int maximumScore(int[] nums, int k) {
        int ans = nums[k], min = nums[k], i = k, j = k, n = nums.length;
        while (i > 0 || j < n - 1) {
            if (i == 0)
                ++j;
            else if (j == n - 1)
                --i;
            else if (nums[i - 1] < nums[j + 1])
                ++j;
            else
                --i;
            min = min(min, min(nums[i], nums[j]));
            ans = max(ans, min * (j - i + 1));
        }
        return ans;
    }
}