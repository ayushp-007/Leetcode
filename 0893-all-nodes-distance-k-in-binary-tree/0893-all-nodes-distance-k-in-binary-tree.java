/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map);
        List<Integer> ans = new ArrayList<>();
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(target.val, 0));
        Set<Integer> set = new HashSet<>();
        set.add(target.val);
        while(!q.isEmpty()) {
            var v = q.poll();
            if(v.getValue() == k) ans.add(v.getKey());
            if(v.getValue() < k) {
                for(int i : map.get(v.getKey())) {
                    if(!set.contains(i)) {  
                        q.add(new Pair(i, v.getValue() + 1));
                        set.add(i);
                    }
                }
            }
        }
        return ans;
    }
    public void dfs(TreeNode root, Map<Integer, List<Integer>> map) {
        if(root == null) return;
        map.putIfAbsent(root.val, new ArrayList<>());
        if(root.left != null) {
            map.putIfAbsent(root.left.val, new ArrayList<>());
            map.get(root.val).add(root.left.val);
            map.get(root.left.val).add(root.val);
        }
        if(root.right != null) {
            map.putIfAbsent(root.right.val, new ArrayList<>());
            map.get(root.val).add(root.right.val);
            map.get(root.right.val).add(root.val);
        }
        dfs(root.left, map);
        dfs(root.right, map);
    }
}