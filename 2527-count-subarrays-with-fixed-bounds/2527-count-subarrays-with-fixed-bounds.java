import static java.lang.Math.*;
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        List<Integer> a = new ArrayList<>();
        for(int i : nums) a.add(i);
        a.add(Integer.MAX_VALUE);
        List<Integer> b = new ArrayList<>();
        long cnt = 0;
        for(int i : a)
        {
            if(i >= minK && i <= maxK) b.add(i);
            else { cnt += solve(b, minK, maxK); b.clear();}
        }
        return cnt;
    }
    public long solve(List<Integer> a, int minK, int maxK){
        int n = a.size();
        int lastMin = -1, lastMax = -1;
        long cnt = 0;
        for(int i = 0; i<n; i++){
            if(a.get(i) == minK) lastMin = i;
            if(a.get(i) == maxK) lastMax = i;
            cnt += min(lastMin, lastMax) + 1;
        }
        return cnt;
    }
}