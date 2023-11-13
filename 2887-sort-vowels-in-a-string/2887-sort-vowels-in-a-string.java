class Solution {
    public String sortVowels(String s) {
        char[] c = s.toCharArray();
        List<Character> a = new ArrayList<>(), b = new ArrayList<>();
        for(var v : c) {
            if(isVowel(v)) a.add(v);
            else b.add(v);
        }
        Collections.sort(a);
        int idx1 = 0, idx2 = 0;
        StringBuilder ans = new StringBuilder();
        for(var v : c) {
            if(isVowel(v)) ans.append(a.get(idx1++));
            else ans.append(b.get(idx2++));
        }
        return ans.toString();
    }
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'; 
    }
}