class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1];
        while(low < high) {
            int mid = (low + high) >>> 1;
            if(check(nums, mid, k)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public boolean check(int[] nums, int x, int k) {
        int n = nums.length;
        int cnt = 0;
        for(int l = 0, r = 1; r < n; r++) {
            while(r > l && nums[r] - nums[l] > x) {
                l++;
            }
            cnt += r - l;
        }
        return cnt < k;
    }
}