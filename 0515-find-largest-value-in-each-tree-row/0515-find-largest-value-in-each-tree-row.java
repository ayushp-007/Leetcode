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
    List<Integer> ans;
    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        levelOrder(root, 0);
        return ans;
    }
    public void levelOrder(TreeNode root, int level) {
        if(root == null) return;
        if(level >= ans.size()) ans.add(root.val);
        else if(root.val > ans.get(level)) ans.set(level, root.val);
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}