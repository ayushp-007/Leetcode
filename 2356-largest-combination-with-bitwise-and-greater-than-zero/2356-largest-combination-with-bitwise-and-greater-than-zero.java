class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length, ans = 0;
        int[] cnt = new int[30];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < 30; j++) {
                cnt[j] += ((candidates[i] >> j) & 1);
            }
        }
        for (int i = 0; i < 30; i++) {
            ans = Math.max(ans, cnt[i]);
        }
        return ans;
    }
}