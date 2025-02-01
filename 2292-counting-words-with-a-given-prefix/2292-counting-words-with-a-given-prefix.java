class Solution {
    public int prefixCount(String[] words, String pref) {
        int l = pref.length();
        int k = 0;
        boolean b;
        for(int i=0;i<words.length;i++){
            b = true;
            if(words[i].length()<l)
                continue;
            for(int j=0;j<l;j++){
                if(words[i].charAt(j) != pref.charAt(j)){
                    b = false;
                    break;
                }
            }
            if(b)
                k++;
        }
        return k;
    }
}