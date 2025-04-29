class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for(int i : nums) max = Math.max(max, i);
        int cnt = 0, n = nums.length;
        long ans = 0;
        for(int i = 0, j = 0; i < n; i++) {
            while(j < n && cnt < k) {
                if(nums[j] == max) cnt++;
                j++;
            }
            if(cnt == k) ans += n - j + 1;
            if(nums[i] == max) cnt--;
        }
        return ans;
    }
}