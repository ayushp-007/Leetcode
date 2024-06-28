class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for(int[] i : roads) {
            degree[i[0]]++;
            degree[i[1]]++;
        }
        Arrays.sort(degree);
        long ans = 0;
        for(int i = 0; i < n; i++) {
            ans += 1L * (n - i) * degree[n - i - 1];
        }
        return ans;
    }
}