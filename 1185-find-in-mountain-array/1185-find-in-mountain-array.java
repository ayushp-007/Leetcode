/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray m) {
        int n = m.length();
        int peak = findPeak(0, n - 2, m);
        int idx1 = i_bs(0, peak, target, m);
        if(m.get(idx1) == target) return idx1;
        int idx2 = d_bs(peak + 1, n - 1, target, m);
        if(m.get(idx2) == target) return idx2;
        return -1;
    }
    public int findPeak(int low, int high, MountainArray m) {
        while(low < high) {
            int mid = (low + high) >>> 1;
            if(m.get(mid) < m.get(mid + 1)) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public int i_bs(int low, int high, int t, MountainArray m) {
        while(low < high) {
            int mid = (low + high) >>> 1;
            if(m.get(mid) >= t) high = mid;
            else low = mid + 1;
        }
        return low;
    }
    public int d_bs(int low, int high, int t, MountainArray m) {
        while(low < high) {
            int mid = (low + high) >>> 1;
            if(m.get(mid) > t) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}