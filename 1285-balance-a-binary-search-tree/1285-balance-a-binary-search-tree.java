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
    List<TreeNode> list;
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        return build(0, list.size() - 1);
    }
    public void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
    public TreeNode build(int start, int end) {
        if(start > end) return null;
        int mid = (start + end) >>> 1;
        TreeNode node = list.get(mid);
        node.left = build(start, mid - 1);
        node.right = build(mid + 1, end);
        return node;
    }
}