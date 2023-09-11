class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = groupSizes.length;
        List<Integer>[] group = new List[n + 1];
        for(int i = 1; i <= n; i++) group[i] = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            group[groupSizes[i]].add(i);

        }
        for(int i = 1; i <=n; i++) {
            int t = group[i].size();
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < t; j++) {
                temp.add(group[i].get(j));
                if(temp.size() == i) {
                    ans.add(temp);
                    temp = new ArrayList<>();
                }
            }
        }
        return ans;
    }
}