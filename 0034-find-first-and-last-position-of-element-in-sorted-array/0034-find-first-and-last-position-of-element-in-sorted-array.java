class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[]{-1, -1};
        int first_pos = 0, last_pos = 0;
        int l = 0, h = n - 1;
        while(l <= h) {
            int m = (l + h) >>> 1;
            if(nums[m] >= target) {
                h = m - 1;
                first_pos = m;
            }
            else {
                l = m + 1;
            }
        }
        l = 0;
        h = n - 1;
        while(l <= h) {
            int m = (l + h) >>> 1;
            if(nums[m] <= target) {
                l = m + 1;
                last_pos = m;
            }
            else {
                h = m - 1;
            }
        }
        if(nums[first_pos] != target) first_pos = -1;
        if(nums[last_pos] != target) last_pos = -1;
        return new int[]{first_pos, last_pos};
    }
}