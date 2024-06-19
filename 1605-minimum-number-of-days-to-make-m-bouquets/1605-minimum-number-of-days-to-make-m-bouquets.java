class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(1L * m * k > bloomDay.length) return -1;
        int low = 0, high = (int) 1e9, ans = 0;
        while(low <= high) {
            int mid = (low + high) >>> 1;
            if(check(mid, bloomDay, m, k)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean check(int x, int[] a, int m, int k) {
        int cnt = 0, total = 0;
        for(int i : a) {
            int val = (i - x)  < 0 ? 0 : (i - x);
            if(val == 0) cnt++;
            else cnt = 0;
            if(cnt == k) {
                total++;
                cnt = 0;
            }
        }
        return total >= m;
    }
}