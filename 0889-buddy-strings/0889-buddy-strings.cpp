class Solution {
public:
    bool buddyStrings(string s, string goal) {
        vector<int> f1(26), f2(26);
        for(auto a : s) f1[a-'a']++;
        for(auto a : goal) f2[a-'a']++;
        if(f1 != f2) return 0;
        int cnt = 0, two = 0;
        for(int i = 0; i<s.size(); i++) {
            if(s[i] != goal[i]) cnt++;
            if(f1[s[i] - 'a'] >= 2) two = 1;
        }
        return cnt == 0 ? two : cnt == 2;
    }
};