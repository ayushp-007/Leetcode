class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i : nums) {
            ans += map.getOrDefault(i, 0);
            map.merge(i, 1, Integer :: sum);
        }
        return ans;
    }
}