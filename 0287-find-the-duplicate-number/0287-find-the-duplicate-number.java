import static java.lang.Math.*;
class Solution {
    public int findDuplicate(int[] nums) {
        int t = 0;
        for(int i : nums){
            t = abs(i);
            if(nums[t] < 0) return t;
            nums[t] = -nums[t];
        }
        return 0;
    }
}