class Solution {
    public int passThePillow(int n, int time) {
        int q = (int)Math.ceil(time/(n-1));
        int r = time%(n-1);
        if((q&1) == 0) return r+1;
        else return n-r;
    }
}