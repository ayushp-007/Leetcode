class Solution {
    public boolean isMonotonic(int[] nums) {
        return increasing(nums) || decreasing(nums);
    }
    public boolean increasing(int[] a) {
        for(int i = 1; i < a.length; i++) {
            if(a[i] < a[i - 1]) return false;
        }
        return true;
    }
    public boolean decreasing(int[] a) {
        for(int i = 1; i < a.length; i++) {
            if(a[i] > a[i - 1]) return false;
        }
        return true;
    }
}