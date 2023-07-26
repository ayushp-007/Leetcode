import static java.lang.Math.*;
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 0, high = (int)(1e7+1);
        while(low < high) {
            int mid = low + (high - low)/2;
            if(good(mid, dist, hour)) high = mid;
            else low = mid + 1;
        }
        return low == (int)(1e7+1) ? -1 : low;
    }
    public boolean good(int val, int[] dist, double hour) {
        double time = 0.0D;
        for(int i = 0; i<dist.length - 1; i++) {
            time += ceil((double)dist[i]/(double)val);
        }
        time += (double)dist[dist.length-1] / (double)val;
        return time <= hour;
    }
}