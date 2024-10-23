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
    List<List<Integer>> list = new ArrayList<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        levelOrder(root, 0);
        List<Integer> sum = new ArrayList<>();
        for(int i = 0; i<list.size(); i++) {
            int temp = 0;
            for(int j : list.get(i)) temp += j;
            sum.add(temp);
        }
        solve(root, null, 0, sum);
        if(root.left != null) root.left.val = 0;
        if(root.right != null) root.right.val = 0;
        return root;
    }
    public void solve(TreeNode root, TreeNode par, int level, List<Integer> sum) {
        if(root == null) return;
        if(par == null){
            root.val = 0;
            solve(root.left, root, level + 1, sum);
            solve(root.right, root, level + 1, sum);
            return;
        }
        int s = 0;
        if(root.left != null) s += root.left.val;
        if(root.right != null) s += root.right.val;
        if(root.left != null) {
            root.left.val = sum.get(level + 1) - s;
            solve(root.left, root, level + 1, sum);
        }
        if(root.right != null) {
            root.right.val = sum.get(level + 1) - s;
            solve(root.right, root, level + 1, sum);
        }
        
    }
    public void levelOrder(TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) list.add(new ArrayList<>());
        list.get(level).add(root.val);
        if(root.left != null) levelOrder(root.left, level + 1);
        if(root.right != null) levelOrder(root.right, level + 1);
    }
}