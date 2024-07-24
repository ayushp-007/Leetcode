class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] a = new int[n][];
        for(int i = 0; i < n; i++) {
            a[i] = new int[]{convert(nums[i], mapping), i};
        }
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = nums[a[i][1]];
        }
        return ans;
    }

    public int convert(int x, int[] mapping) {
        if(x == 0) return mapping[0];
        int t = 0;
        for(int i = 1; x > 0; i *= 10) {
            int a = x / 10, b = x % 10;
            t += mapping[b] * i;
            x = a;
        }
        return t;
    }
}