class Solution {
public:
    int numWays(int steps, int arrLen) {
        int MOD = 1e9 + 7;
        map<pair<int, int>, long long> mp;
        function<long long(int, int)> recur = [&](int i, int j) {
            if(i == steps) return j == 0 ? 1ll : 0ll;
            if(mp.find({i, j}) != mp.end()) return mp[{i, j}];
            long long ans = 0;
            if(j - 1 >= 0) ans += recur(i + 1, j - 1), ans %= MOD;
            if(j + 1 < arrLen) ans += recur(i + 1, j + 1), ans %= MOD;
            ans += recur(i + 1, j), ans %= MOD;
            return mp[{i, j}] = ans;
        };
        return (int)recur(0, 0);
    }
};