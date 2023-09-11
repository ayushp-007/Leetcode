class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = groupSizes.length;
        for(int i = 1; i<=n; i++) {
            List<Integer> temp = new ArrayList<>();
            int size = 0;
            for(int j = 0; j < n; j++) {
                if(size == i) {
                    ans.add(temp);
                    temp = new ArrayList<>();
                    size = 0;
                }
                if(groupSizes[j] == i) {
                    temp.add(j);
                    size++;
                }
            }
            if(size != 0) ans.add(temp);
        }
        return ans;
    }
}