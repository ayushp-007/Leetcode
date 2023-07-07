import static java.lang.Math.*;
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] c = answerKey.toCharArray();
        int i = 0, j = 0, f = 0, n = c.length;
        while(i <= j && j < n) {
            map.merge(c[j], 1, Integer :: sum);
            f = max(f, map.get(c[j]));
            while(j - i + 1 > f + k) {
                map.merge(c[i], -1, Integer :: sum);
                if(map.get(c[i]) == 0) map.remove(c[i]);
                i++;
            }
            j++;
        }
        return n - i;
    }
}