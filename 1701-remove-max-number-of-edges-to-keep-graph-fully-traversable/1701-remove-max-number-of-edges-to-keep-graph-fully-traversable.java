public class DSU {
    int[] parent, rank, size;
    DSU(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        size = new int[n+1];
        for(int i = 0; i<=n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    int find(int x) {
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int a, int b) {
        int u = find(a);
        int v = find(b);
        parent[u] = v;
    }
    void unionRank(int a, int b) {
        int u = find(a);
        int v = find(b);
        if(u == v) return;
        if(rank[u] < rank[v]) {
            parent[u] = v;
        }
        else if(rank[v] < rank[u]) {
            parent[v] = u;
        }
        else {
            parent[v] = u;
            rank[u]++;
        }
    }
    void unionSize(int a, int b) {
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
    boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n), bob = new DSU(n);
        int cnt = 0;
        for(int[] i : edges) {
            if(i[0] == 3) {
                if(!alice.isConnected(i[1], i[2])){
                    alice.union(i[1], i[2]);
                    bob.unionRank(i[1], i[2]);
                    cnt++;
                }
            }
        }
        for(int[] i : edges) {
            if(i[0] == 1) {
                if(!alice.isConnected(i[1], i[2])) {
                    alice.unionRank(i[1], i[2]);
                    cnt++;
                }
            }
            if(i[0] == 2) {
                if(!bob.isConnected(i[1], i[2])) {
                    bob.unionRank(i[1], i[2]);
                    cnt++;
                }
            }
        }
        int ult_A = alice.find(1), ult_B = bob.find(1);
        for(int i = 1; i<=n; i++) {
            if(!alice.isConnected(ult_A,i)) return -1;
            if(!bob.isConnected(ult_B,i)) return -1;
        }
        return edges.length - cnt;
    }
}