import static java.lang.Math.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> ans = new HashSet<>();
        int n = nums.length;
        for(int i : nums){
            map.merge(i, 1, Integer :: sum);
            if(map.get(i) > (int)floor((double)n/3.0D)) ans.add(i);
        }
        List<Integer> list = new ArrayList<>(ans);
        return list;
    }
}