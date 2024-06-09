class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int cnt = 0;
        int n = nums.length;
        int[] pre = new int[n+1];int[] f = new int[k];
        for(int i = 0; i<n; i++){
            pre[i+1] = pre[i] + nums[i];
            int t =( pre[i+1]%k + k )%k;
            f[t]++;
        }
        cnt = f[0];
        for(int i : f){
            cnt += i*(i-1)/2;
        }
        return cnt;
    }
}