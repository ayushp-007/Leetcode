import static java.lang.Math.*;
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, ans = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i : nums) set.add(i);
        List<Integer> list = new ArrayList<>(set);
        for(int i = 0, j = 0; i < list.size(); i++) {
            while(j < list.size() && list.get(j) - list.get(i) < n) {
                j++;
            }
            ans = max(ans, j - i);
        }
        return n - ans;
    }
}