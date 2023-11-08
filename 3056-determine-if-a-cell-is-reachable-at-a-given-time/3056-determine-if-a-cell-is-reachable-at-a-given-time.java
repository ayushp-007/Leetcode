import static java.lang.Math.*;
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int d = max(abs(sx - fx), abs(sy - fy));
        if(d == 0 && t == 1) return false;
        return t >= d;
    }
}