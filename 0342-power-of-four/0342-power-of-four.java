import static java.lang.Math.*;
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        double log = log(n) / log(4);
        return log == (int)log;
    }
}