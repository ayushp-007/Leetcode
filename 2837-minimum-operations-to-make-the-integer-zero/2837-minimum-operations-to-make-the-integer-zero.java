class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i = 1; i <= 60; i++) {
            long x = (long)num1 - ((long)i * (long)num2);
            if(x < 0) continue;
            long y = Long.bitCount(x);
            if(y <= (long)i && (long)i <= x) return i;
        }
        return -1;
    }
}