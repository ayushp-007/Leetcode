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
    public TreeNode bstToGst(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Pair<TreeNode, Integer>> list = new ArrayList<>();
        for(var i : map.keySet()) {
            list.add(new Pair(i, map.get(i)));
        }
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        int sum = 0;
        for(var i : list) {
            sum += i.getValue();
            i.getKey().val = sum;
        }
        return root;
    }
    public void dfs(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null) return;
        map.put(root, root.val);
        dfs(root.left, map);
        dfs(root.right, map);
    }
}