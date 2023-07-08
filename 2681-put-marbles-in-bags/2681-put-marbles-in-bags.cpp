class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        vector<int> a;
        int n = weights.size();
        for(int i = 0; i<n - 1; i++) a.push_back(weights[i] + weights[i + 1]);
        sort(a.begin(), a.end());
        long long max = 0, min = 0;
        for(int i= 0; i<k-1; i++) min += a[i];
        for(int i = n-2, t = 0; t<k-1; t++, i--) max += a[i];
        return max - min;
    }
};