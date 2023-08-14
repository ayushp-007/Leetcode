class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0, n = nums.length;
        if(n == 1) return 1;
        for(int i = 0; i<n - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                while(i < n - 1 && nums[i] == nums[i + 1]) i++;
                nums[idx] = nums[i];
                nums[idx + 1] = nums[i];
                idx += 2;
            }
            else {
                nums[idx] = nums[i];
                idx++;
            }
        }
        // System.out.println(Arrays.toString(nums));
        if(nums[n - 1] != nums[n - 2]) {
            nums[idx] = nums[n - 1];
            idx++;
        }
        return idx;
    }
}