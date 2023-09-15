import static java.lang.Math.*;
class DSU {
    int[] parent, size;
    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    int find(int x) {
        return parent[x] = parent[x] == x ? parent[x] : find(parent[x]);
    }
    void union(int a, int b) {
        int u = find(a);
        int v = find(b);
        if(u == v) return;
        if(size[u] < size[v]) {
            parent[u] = v;
            size[v] += size[u];
        }
        else {
            parent[v] = u;
            size[u] += size[v];
        }
    }
    boolean connected(int u, int v) {
        return find(u) == find(v);
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        int[][] edges = new int[n * (n - 1) / 2][];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                edges[idx++] = new int[]{i, j, dis(points[i], points[j])};
            }
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int ans = 0;
        for(var i : edges) {
            if(dsu.connected(i[0], i[1])) continue;
            ans += i[2];
            dsu.union(i[0], i[1]);
        }
        return ans;
    }
    public int dis(int[] a, int[] b) {
        return abs(a[0] - b[0]) + abs(a[1] - b[1]);
    }
}