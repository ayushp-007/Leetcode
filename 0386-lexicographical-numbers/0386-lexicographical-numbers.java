class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> l = new ArrayList<>();
        for(int i = 1; i<= n; i++){
            l.add(i+"");
        }
        Collections.sort(l);
        List<Integer> ans = new ArrayList<>();
        for(String i : l) ans.add(Integer.valueOf(i));
        return ans;
    }
}