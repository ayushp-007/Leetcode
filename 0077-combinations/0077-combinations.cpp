class Solution {
public:
    vector<vector<int>> ans;
    vector<vector<int>> combine(int n, int k) {
        vector<int> temp;
        recur(1, n, k, temp);
        return ans;
    }
    void recur(int i, int n, int k, vector<int>& temp) {
        if(temp.size() == k) {
            ans.push_back(temp);
            return;
        }
        if(i > n) return;
        temp.push_back(i);
        recur(i + 1, n, k, temp);
        temp.pop_back();
        recur(i + 1, n , k, temp);
    }
};