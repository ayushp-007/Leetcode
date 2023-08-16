class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < k; i++) map.merge(nums[i], 1, Integer :: sum);
        int n = nums.length, m = n - k + 1;
        int[] ans = new int[m];
        ans[0] = map.lastKey();
        for(int i = k, j = 1, idx = 0; i < n && j < m; i++, j++, idx++) {
            map.merge(nums[idx], -1, Integer :: sum);
            if(map.get(nums[idx]) == 0) map.remove(nums[idx]);
            map.merge(nums[i], 1, Integer :: sum);
            ans[j] = map.lastKey();
        }
        return ans;
    }
}