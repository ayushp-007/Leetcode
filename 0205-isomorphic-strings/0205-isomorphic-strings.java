class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] a = s.toCharArray(), b = t.toCharArray();
        Map<Character, Character> map1 = new HashMap<>(), map2 = new HashMap<>();
        for(int i = 0; i<a.length; i++) {
            if(!map1.containsKey(a[i]) && !map2.containsKey(b[i])) {
                map1.put(a[i], b[i]);
                map2.put(b[i], a[i]);
            }
            else if(!map1.containsKey(a[i]) || !map2.containsKey(b[i])) return false;
            else if(map1.get(a[i]) != b[i] || map2.get(b[i]) != a[i]) return false;
        }
        return true;
    }
}