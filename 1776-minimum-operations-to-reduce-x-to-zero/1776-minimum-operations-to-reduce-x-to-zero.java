import static java.lang.Math.*;
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0, n = nums.length;
        for(int i : nums) sum += i;
        sum -= x;
        if(sum == 0) return n;
        int ans = 0;
        for(int i = 0, j = 0, curr = 0; j < n; j++) {
            curr += nums[j];
            while(i <= j && curr > sum) curr -= nums[i++];
            if(curr == sum) ans = max(ans, j - i + 1);
        }
        return ans == 0 ? -1 : n - ans;
    }
}