class Solution {
    public int numRabbits(int[] answers) {
        int[] f = new int[1001];
        for(int i : answers) f[i]++;
        int ans = 0;
        for(int i = 0; i<1001; i++){
            int t = f[i]/(i+1);
            if(f[i] % (i+1) != 0) t++;
            ans += t*(i+1);
        }
        return ans;
    }
}