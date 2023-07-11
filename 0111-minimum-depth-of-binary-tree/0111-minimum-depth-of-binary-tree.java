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
import static java.lang.Math.*;
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 1);
    }
    public int dfs(TreeNode root, int depth) {
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return depth;
        return min(dfs(root.left, depth + 1), dfs(root.right, depth + 1));
    }
}