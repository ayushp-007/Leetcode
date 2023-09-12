class Solution {
    public int minDeletions(String s) {
        int[]  f = new int[26];
        for(char c : s.toCharArray()){
            f[c-'a']++;
        }
        Arrays.sort(f);
        int k = 0;
        for(int i = 24;i>=0;i--){
            if(f[i] == 0){
                break;
            }
            else if(f[i+1] == 0){
                k += f[i]-0;
                f[i] = 0;
            }
            else if(f[i] == f[i+1]){
                f[i]--;
                k++;
            }
            else if(f[i]>f[i+1]){
                int t = f[i+1]-1;
                k += (f[i]-t);
                f[i] = t;
            }
            
        }
        return k;
    }
}