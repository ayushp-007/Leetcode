# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        def levelOrder(root, level):
            if root == None: 
                return
            if level >= len(ans):
                ans.append(root.val)
            elif root.val > ans[level]:
                ans[level] = root.val
            levelOrder(root.left, level + 1)
            levelOrder(root.right, level + 1)
        levelOrder(root, 0)
        return ans