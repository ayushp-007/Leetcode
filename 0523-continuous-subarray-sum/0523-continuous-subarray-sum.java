class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int currsum = 0 , prevsum = 0;
        for(int i : nums) {
            currsum += i;
            if(set.contains(currsum % k)) return true;
            set.add(prevsum%k);
            prevsum = currsum;
        }
        return false;
    }
}