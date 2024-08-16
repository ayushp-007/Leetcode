import static java.lang.Math.*;
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int small = arrays.get(0).get(0);
        int big = arrays.get(0).get(arrays.get(0).size() - 1);
        int ans = 0;

        for(int i = 1; i < arrays.size(); i++) {
            ans = max(ans, abs(arrays.get(i).get(arrays.get(i).size() - 1) - small));
            ans = max(ans, abs(big - arrays.get(i).get(0)));
            small = min(small, arrays.get(i).get(0));
            big = max(big, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        
        return ans;
    }
}