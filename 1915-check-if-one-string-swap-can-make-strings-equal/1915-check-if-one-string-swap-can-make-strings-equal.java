class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
        
        if(s2.length()!=s1.length()) return false;
        int first=-1;
        boolean swapped = false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(swapped) return false;
                if(first==-1) first = i;
                else if(!swapped&&s1.charAt(i)==s2.charAt(first)&&s1.charAt(first)==s2.charAt(i)) swapped = true;
                else return false;
            }
        }
        return swapped||(first==-1&&!swapped);
    }
}