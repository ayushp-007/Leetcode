class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0, cnt = 0;
        int[] f = new int[nums.length + 1];
        f[0] = 1;
        for(int i : nums) {
            if(i % 2 == 1) cnt++;
            if(cnt - k >= 0) ans += f[cnt - k];
            f[cnt]++;
        }
        return ans;
    }
}