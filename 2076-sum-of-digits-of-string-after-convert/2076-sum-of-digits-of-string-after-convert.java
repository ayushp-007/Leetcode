class Solution {
    public int getLucky(String s, int k) {
        int res = 0,len = s.length(),i=0;
        int num;
        while(i<len){
            num = s.charAt(i++)-96;
            res+=sum(num);
        }
        while(k>1){
            res = sum(res);
            k--;
        }
        return res;
    }
    public static int sum(int num){
        int res = 0;
        while(num>0){
            res+=(num%10);
            num/=10;
        }
        return res;
	}
}