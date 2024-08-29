class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] parent = new int[n+1];
        for(int i = 0 ; i <= n; i++) parent[i] = i;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    int x = find(i, parent);
                    int y = find(j, parent);
                    if(x != y) parent[y] = x;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i< n; i++) ans += parent[i] == i ? 1 : 0;
        return n - ans;
        
    }
    public int find(int a, int[] parent){
        return parent[a] == a ? a : find(parent[a],parent);
     }
}