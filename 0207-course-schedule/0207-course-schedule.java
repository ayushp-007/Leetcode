class Solution {
    List<Integer>[] adj;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new List[numCourses];
        for(int i = 0; i<numCourses; i++) adj[i] = new ArrayList<>();
        for(int i[] : prerequisites) {
            adj[i[1]].add(i[0]);
        }
        boolean[] vis1 = new boolean[numCourses], vis2 = new boolean[numCourses];
        for(int i = 0; i<numCourses; i++) if(cycle(i, vis1, vis2)) return false;
        return true;
    }
    public boolean cycle(int node, boolean[] vis1, boolean[] vis2) {
        if(vis2[node]) return true;
        if(vis1[node]) return false;
        vis1[node] = true;
        vis2[node] = true;
        for(int i : adj[node]) if(cycle(i, vis1, vis2)) return true;
        vis2[node] = false;
        return false;
    }
}