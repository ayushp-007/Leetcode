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
    Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        map.put(root.val, new Pair(-1, 0));
        levelOrder(root, 0);
        var X = map.get(x);
        var Y = map.get(y);
        return X.getValue() == Y.getValue() && X.getKey() != Y.getKey();
    }
    public void levelOrder(TreeNode root, int level) {
        if(root == null) return;
        if(root.left != null) {
            map.put(root.left.val, new Pair(root.val, level + 1));
        }
        if(root.right != null) {
            map.put(root.right.val, new Pair(root.val, level + 1));
        }
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}