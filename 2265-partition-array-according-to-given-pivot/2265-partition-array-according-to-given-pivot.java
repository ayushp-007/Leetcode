class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        Arrays.sort(a, (x, y) -> x[0] < pivot && y[0] < pivot ? x[1] - y[1] : x[0] > pivot && y[0] > pivot ? x[1] - y[1] : x[0] - y[0]);
        for (int i = 0; i < n; i++) {
            nums[i] = a[i][0];
        }
        return nums;
    }
}