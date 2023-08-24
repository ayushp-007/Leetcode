class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        for(int i = 0; i<numCourses; i++) adj[i] = new ArrayList<>();
        for(int[] i : prerequisites) {
            adj[i[1]].add(i[0]);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i<numCourses; i++) for(int j : adj[i]) indegree[j]++;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++) if(indegree[i] == 0) q.add(i);
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()) {
            int t = q.poll();
            ans[idx++] = t;
            for(int i : adj[t]) {
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }
        if(idx == numCourses) return ans;
        return new int[0];
    }

}