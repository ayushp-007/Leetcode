class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        unordered_map<char, int> mp;
        for(auto a : s1) mp[a]++;
        int n = s1.size();
        for(int i = 0; i<s2.size(); i++){
            mp[s2[i]]--;
            if(mp[s2[i]] == 0) mp.erase(s2[i]);
            if(i-n>=0) {
                mp[s2[i-n]]++;
                if(mp[s2[i-n]] == 0) mp.erase(s2[i-n]);
            }
            if(mp.size() == 0) return true;
        }
        return false;
    }
};