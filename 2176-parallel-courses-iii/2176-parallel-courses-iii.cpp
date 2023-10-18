class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        vector<vector<int>> adj(n);
        vector<int> indegree(n, 0), seen(n, 0);
        for(auto i : relations) {
            int u = i[0] - 1, v = i[1] - 1;
            indegree[v]++;
            adj[u].push_back(v);
        }
        queue<int> q;
        for(int i = 0; i < n; i++) if(!indegree[i]) q.push(i);
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            for(int i : adj[node]) {
                indegree[i]--;
                seen[i] = max(seen[i], seen[node] + time[node]);
                if(!indegree[i]) q.push(i);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) ans = max(ans, time[i] + seen[i]);
        return ans;
    }
};