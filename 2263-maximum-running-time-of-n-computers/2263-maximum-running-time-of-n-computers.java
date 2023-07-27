import static java.lang.Math.*;
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long low = 0, high = 0, ans = -1;
        for(var i : batteries) high += i;
        while(low <= high) {
            long mid = (low + high) / 2;
            if(check(mid, n, batteries)) {
                low = mid + 1;
                ans = mid;
            }
            else high = mid - 1;
        }
        return ans;
    }
    public boolean check(long mid, int n, int[] batteries) {
        long time = 0;
        for(int i : batteries) time += min((long)i, mid);
        return mid * n <= time;
    }
}