class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(var i : tickets) {
            adj.putIfAbsent(i.get(0), new PriorityQueue<>());
            adj.get(i.get(0)).add(i.get(1));
        }
        List<String> ans = new ArrayList<>();
        dfs("JFK", adj, ans);
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(String node, Map<String, PriorityQueue<String>> adj, List<String> ans) {
        PriorityQueue<String> q = adj.get(node);
        while(q != null && !q.isEmpty()) dfs(q.poll(), adj, ans);
        ans.add(node);
    }
}