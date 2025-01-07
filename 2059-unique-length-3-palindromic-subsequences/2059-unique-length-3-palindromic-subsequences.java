import static java.lang.Math.*;
class Solution {
    public int countPalindromicSubsequence(String inputString) {
        char[] c = inputString.toCharArray();
        int firstIndex[] = new int[26], lastIndex[] = new int[26], ans = 0;
        Arrays.fill(firstIndex, Integer.MAX_VALUE);
        for (int i = 0; i < inputString.length(); ++i) {
            firstIndex[c[i] - 'a'] = min(firstIndex[c[i] - 'a'], i);
            lastIndex[c[i] - 'a'] = i;
        }
        for (int i = 0; i < 26; ++i)
            if (firstIndex[i] < lastIndex[i])
                ans += inputString.substring(firstIndex[i] + 1, lastIndex[i]).chars().distinct().count();
        return ans;
    }
}