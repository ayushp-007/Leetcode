class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        map<int, int> mp;
        for(int i : nums) mp[i]++;
        int ans = 0;
        for(auto& [a, b]: mp) ans += b *  (b - 1) / 2;
        return ans;
    }
};