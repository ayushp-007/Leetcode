class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<vector<int>> adj(n);
        vector<int> safe, ans;
        queue<int> q;
        for(int i = 0; i<n; i++) {
            for(auto a : graph[i]) adj[a].push_back(i);
            safe.push_back(graph[i].size());
            if(!safe[i]) q.push(i);
        }
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            for(int i : adj[node]) {
                safe[i]--;
                if(!safe[i]) q.push(i);
            }
        }
        for(int i = 0; i<n; i++) if(!safe[i]) ans.push_back(i);
        return ans;
    }
};