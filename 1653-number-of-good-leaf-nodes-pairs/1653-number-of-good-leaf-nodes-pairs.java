/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    public int countPairs(TreeNode root, int distance) {
        if(root == null) return 0;
        dfs(root, distance);
        return ans;
    }
    public int[] dfs(TreeNode root, int n) {
        if(root == null) return new int[n];
        if(root.left == null && root.right == null) {
            int[] a = new int[n];
            a[0]++;
            return a;
        }
        int[] left = dfs(root.left, n);
        int[] right = dfs(root.right, n);
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
                if(i + j <= n) ans += left[i - 1] * right[j - 1];
            }
        }
        int[] a = new int[n];
        for(int i = n - 2; i>=0; i--) a[i + 1] = left[i] + right[i];
        return a;
    }
}