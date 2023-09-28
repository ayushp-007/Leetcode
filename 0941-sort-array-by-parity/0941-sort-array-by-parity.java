class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length, even = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 == 0) swap(nums, i, even++);
        }
        return nums;
    }
    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}