import static java.lang.Math.*;
class Solution {
    public int bestClosingTime(String customers) {
        char[] c = customers.toCharArray();
        int n = c.length;
        int[] pre1 = new int[n+1];
        int[] pre2 = new int[n+1];
        pre1[0] = 0;
        pre2[0] = 0;
        for(int i = 0; i<n; i++){
            if(c[i] == 'Y'){
                pre1[i+1] = pre1[i] + 1;
            }
            else{
                pre1[i+1] = pre1[i];
            }
            if(c[i] == 'N'){
                pre2[i+1] = pre2[i]+1;
            }
            else{
                pre2[i+1] = pre2[i];
            }
        }
        
        int max = 0, time = 0;
        for(int i = 1; i<=n; i++){
            int curr = pre1[i]-pre2[i];
            if(curr > max){
                max = curr;
                time = i;
            }
        }
        return time;
    }
}