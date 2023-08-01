class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        recur(1, n, k, new ArrayList<>());
        return ans;
    }
    public void recur(int curr, int n, int k, List<Integer> list) {
        if(list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(curr > n) return;
        list.add(curr);
        recur(curr + 1, n, k, list);
        list.remove(list.size() - 1);
        recur(curr + 1, n, k, list);
    }
}