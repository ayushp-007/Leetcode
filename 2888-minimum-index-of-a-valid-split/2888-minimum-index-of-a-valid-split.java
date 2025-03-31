class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> mp1 = new HashMap<>(), mp2 = new HashMap<>();
        for(int i : nums) mp2.merge(i, 1, Integer :: sum);
        int n = nums.size();
        for(int i = 0; i<n; i++) {
            int val = nums.get(i);
            int l1 = i - 0 + 1, l2 = n - i - 1;
            mp1.merge(val, 1, Integer :: sum);
            mp2.merge(val, -1, Integer :: sum);
            if(mp2.get(val) == 0) mp2.remove(val);
            if(mp1.get(val) * 2 > l1 && mp2.getOrDefault(val, 0) * 2 > l2 ) return i;
        }
        return -1;
    }
}