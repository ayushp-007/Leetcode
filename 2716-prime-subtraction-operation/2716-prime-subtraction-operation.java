class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean[] prime = new boolean[1001];
        prime[0] = true;
        for(int i = 2; i < 1001; i++) {
            prime[i] = true;
            for(int j = 2; j*j <= i; j++) {
                if(i % j == 0) {
                    prime[i] = false;
                    break;
                }
            }
        }
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            boolean find = false;
            for(int j = 1000; j >= 0; j--) {
                if(prime[j] && nums[i] > j && (i == 0 || nums[i - 1] < nums[i] - j)) {
                    nums[i] -= j;
                    find = true;
                    break;
                }
            }
            if(!find) {
                return false;
            }
        }
        return true;
    }
}