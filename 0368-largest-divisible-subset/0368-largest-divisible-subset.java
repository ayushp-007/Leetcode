class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.parallelSort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        int max = 0, idx = -1;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            dp[i] = 1;
            for(int j = i-1; j >=0 ;j--){
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                idx = i;
            }
        } 
        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(dp));  
        while(idx != -1){
            ans.add(nums[idx]);
            idx = prev[idx];
        }
        return ans;
    }
}