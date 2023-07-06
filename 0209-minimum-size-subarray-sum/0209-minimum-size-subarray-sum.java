import static java.lang.Math.*;
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        int ans = Integer.MAX_VALUE;
        int i=0,j=0;
        while(i<n && j<n){
            int sum = prefix[j]-prefix[i]+nums[i];
            if(sum >= target){
                ans = min(ans,j-i+1);
                i++;
            }
            else{
                j++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}