class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(numCourses);
        vector<bool> vis1(numCourses, 0), vis2(numCourses, 0);
        for(auto a : prerequisites) adj[a[1]].push_back(a[0]);
        for(int i = 0; i<numCourses; i++) if(cycle(i, vis1, vis2, adj)) return false;
        return true;
    }
    bool cycle(int node, vector<bool> &vis1, vector<bool> &vis2, vector<vector<int>> &adj) {
        if(vis2[node]) return true;
        if(vis1[node]) return false;
        vis1[node] = true;
        vis2[node] = true;
        for(int i : adj[node]) if(cycle(i, vis1, vis2, adj)) return true;
        vis2[node] = false;
        return false;
    }
};