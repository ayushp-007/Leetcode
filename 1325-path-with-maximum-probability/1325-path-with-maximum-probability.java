import static java.util.Arrays.*;
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair<Integer, Double>>[] adj = new List[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i<edges.length; i++) {
            adj[edges[i][0]].add(new Pair(edges[i][1], succProb[i]));
            adj[edges[i][1]].add(new Pair(edges[i][0], succProb[i]));
        }
        double[] prob = new double[n];
        fill(prob, 0D);
        PriorityQueue<Pair<Integer, Double>> q = new PriorityQueue<>((a,b)->Double.compare(b.getValue(), a.getValue()));
        prob[start] = 1D;
        q.add(new Pair(start, 1D));
        while(!q.isEmpty()) {
            var node = q.poll();
            for(var i : adj[node.getKey()]) {
                if(prob[node.getKey()] * i.getValue() > prob[i.getKey()]) {
                    prob[i.getKey()] = prob[node.getKey()] * i.getValue();
                    q.add(new Pair(i.getKey(), prob[i.getKey()]));
                }
            }
        }
        return prob[end];
    }
}