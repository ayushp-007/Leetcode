class Solution {
    public int minimumDeletions(String s) {
        char[] c = s.toCharArray();
        int n = c.length, cnt = 0;
        int[] f = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(c[i - 1] == 'b') {
                f[i] = f[i - 1];
                cnt += 1;
            }
            else {
                f[i] = Math.min(f[i - 1] + 1, cnt);
            }
        }
        return f[n];
    }
}