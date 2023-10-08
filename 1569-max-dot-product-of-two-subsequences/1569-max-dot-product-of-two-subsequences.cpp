class Solution {
public:
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size(), m = nums2.size(), inf = 1e9;
        int dp[n][m][2];
        memset(dp, -1, sizeof(dp));
        function<int(int, int, int)> recur = [&](int i, int j, int k) {
            if(i == n || j == m) {
                if(k == 1) return 0;
                return -inf;
            }
            auto &a = dp[i][j][k];
            if(a != -1) return a;
            a = -inf;
            a = max(a, nums1[i] * nums2[j] + recur(i + 1, j + 1, 1));
            a = max(a, recur(i + 1, j, k));
            a = max(a, recur(i, j + 1, k));
            return a;
        };
        return recur(0, 0, 0);
    }
};