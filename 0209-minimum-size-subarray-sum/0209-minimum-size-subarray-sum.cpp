class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size();
        vector<int> pre(n);
        pre[0] = nums[0];
        for(int i = 1; i<n; i++) pre[i] = pre[i - 1] + nums[i];
        int i = 0, j = 0, ans = INT_MAX;
        while(i <= j && j < n) {
            if(pre[j] - pre[i] + nums[i] >= target) {
                ans = min(ans, j - i + 1);
                i++;
            }
            else j++;
        }
        return ans == INT_MAX ? 0 : ans;
    }
};