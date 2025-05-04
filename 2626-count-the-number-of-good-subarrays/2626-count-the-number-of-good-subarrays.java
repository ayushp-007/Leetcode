class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0;
        long t = 0;
        long n = nums.length;
        int l = 0, r = 0;
        for (r = 0; r < (int)n; r++) {
            if (map.containsKey(nums[r])) {
                t += map.get(nums[r]);
            }
            map.merge(nums[r], 1, Integer :: sum);
            while (l <= r && t >= k) {
                if (map.get(nums[l]) > 1) {
                    t -= (map.get(nums[l]) - 1);
                }
                map.merge(nums[l], -1, Integer :: sum);
                l++;
            }
            cnt += (r - l + 1);
        }
        return (long)(n*(n+1L)/2L) - cnt;
    }
}