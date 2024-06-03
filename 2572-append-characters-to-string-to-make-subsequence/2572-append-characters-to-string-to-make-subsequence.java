class Solution {
    public int appendCharacters(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int idx = 0;
        for(int i = 0; i<a.length && idx < b.length; i++){
            if(a[i] == b[idx]) idx++; 
        }
        return b.length-idx;
    }
}