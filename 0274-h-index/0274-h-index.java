import static java.lang.Math.*;
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length, ans = 0;
        for(int i = 0; i<n; i++) ans = max(ans, min(citations[i], n - i));
        return ans;
    }
}