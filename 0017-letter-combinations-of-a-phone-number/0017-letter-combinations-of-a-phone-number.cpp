class Solution {
public:
    vector<string> ans, map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    vector<string> letterCombinations(string digits) {
        if(digits == "") return ans;
        recur(0, digits, "");
        return ans;
    }
    void recur(int i, string& s, string t) {
        if(i == s.size()) {
            ans.push_back(t);
            return;
        }
        for(char c : map[s[i] - '0']) recur(i + 1, s, t + c);
    }
};