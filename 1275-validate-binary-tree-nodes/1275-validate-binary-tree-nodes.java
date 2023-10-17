class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];
        int edges = 0;
        for(int i : leftChild) if(i != -1) { indegree[i]++; edges++;}
        for(int i : rightChild) if(i != -1) { indegree[i]++; edges++;}
        if(edges != n - 1) return false;
        int root = getRoot(indegree);
        if(root == -1) return false;
        Set<Integer> set = new HashSet<>();
        recur(root, leftChild, rightChild, set);
        return set.size() == n;
    } 
    public void recur(int node, int[] a, int[] b, Set<Integer> set) {
        if(node == -1 || set.contains(node)) return;
        set.add(node);
        recur(a[node], a, b, set);
        recur(b[node], a, b, set);
    }
    public int getRoot(int[] a) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] == 0) return i;
        }
        return -1;
    }
}