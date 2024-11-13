class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long ct = 0;
        for (int i = 0; i < n; i++) {
            int j = lowerBound(nums, i + 1, n, lower - nums[i]);
            int k = upperBound(nums, i + 1, n, upper - nums[i]) - 1;
            if (j <= k) {
                ct += (long)(k - j + 1);
            }
        }
        return ct;
    }
    
    private int lowerBound(int[] nums, int start, int end, int target) {
        int left = start, right = end - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    private int upperBound(int[] nums, int start, int end, int target) {
        int left = start, right = end - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}