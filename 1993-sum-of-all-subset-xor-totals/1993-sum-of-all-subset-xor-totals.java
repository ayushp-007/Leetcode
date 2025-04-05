class Solution {
    int subset(int[] a , int i,int n,int sum){
        if(i == n){
            return sum;
        }
        int l = subset(a,i+1,n,a[i]^sum);
        int r = subset(a,i+1,n,sum);
        return l+r;
    }
    public int subsetXORSum(int[] nums) {
        return subset(nums,0,nums.length,0);
    }
}