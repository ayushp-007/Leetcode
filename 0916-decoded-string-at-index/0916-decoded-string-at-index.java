class Solution {
    public String decodeAtIndex(String s, int k) {
        long n = 0;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') n *= (c - '0');
            else n++;
        }
        for(int i = s.length() - 1; i >=0; i--) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                n /= (c - '0');
                k %= n;
            }
            else {
                k %= n;
                if(k == 0) return ""+c;
                n--;
            }
        }
        return "";
    }
}