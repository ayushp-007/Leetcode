import static java.lang.Math.*;
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] a = new int[n];
        for(int i = 0; i<n; i++) {
            String[] s = timePoints.get(i).split(":");
            a[i] = (Integer.valueOf(s[0]) * 60) + Integer.valueOf(s[1]);
        }
        Arrays.sort(a);
        int ans = (a[0] - a[n - 1] + 1440) % 1440;
        for(int i = 0; i<n - 1; i++) ans = min(ans, a[i + 1] - a[i]);
        return ans;
    }
}