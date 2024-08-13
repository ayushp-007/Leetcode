class Solution {
    void find(int idx,int n,int[] a,List<List<Integer>> ans,List<Integer> l,int target){
        if(target == 0){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i = idx;i<n;i++){
            if(i>idx && a[i] == a[i-1])continue;
            if(a[i]>target)break;
            l.add(a[i]);
            find(i+1,n,a,ans,l,target-a[i]);
            l.remove(l.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        find(0,candidates.length,candidates,ans,new ArrayList<>(),target);
        return ans;
    }
}