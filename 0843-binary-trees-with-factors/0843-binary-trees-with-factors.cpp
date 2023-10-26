class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& a) {
        int n = a.size(), mod = 1e9 + 7;
        sort(a.begin(), a.end());
        map<int, long long> mp;
        long long ans = 1;
        mp[a[0]] = 1;
        for(int i = 1; i < n; i++) {
            long long cnt = 1;
            for(int j = 0; j < i; j++) {
                if(a[i] % a[j] == 0 && mp[a[i] / a[j]]) {
                    cnt += mp[a[j]] * mp[a[i] / a[j]];
                }
            }
            ans += cnt;
            mp[a[i]] = cnt;
        }
        return ans % mod;
    }
};