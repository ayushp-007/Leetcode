class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n/2; i++) {
            sb.append(s.charAt(i));
            if(n % sb.length() == 0) {
                int t = n / sb.length();
                StringBuilder temp = new StringBuilder();
                while(t-->0) temp.append(sb);
                if(s.equals(temp.toString())) return true;
            }
        }
        return false;
    }
}