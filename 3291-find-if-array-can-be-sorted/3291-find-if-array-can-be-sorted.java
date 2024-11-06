class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] setBits = new int[n];
        for (int i = 0; i < n; i++) {
            setBits[i] = Integer.bitCount(nums[i]);
        }
        for (int i = 0, j = 0; j < n; ) {
            while(j < n && setBits[i] == setBits[j]) {
                pq.add(nums[j]);
                j += 1;
            }
            for (int k = i; k < j; k++) {
                nums[k] = pq.poll();
            }
            i = j;
        }
        return isSorted(nums);
    }

    private boolean isSorted(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}