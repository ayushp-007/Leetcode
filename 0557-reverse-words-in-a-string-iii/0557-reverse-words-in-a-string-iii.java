class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String i : str) {
            StringBuilder temp = new StringBuilder(i);
            ans.append(temp.reverse() + " ");
        }
        return ans.toString().substring(0, ans.length() - 1);
    }
}