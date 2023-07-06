# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return False
        dict = {}
        dict[root.val] = [-1, 0]
        def levelOrder(root, level):
            if root == None:
                return
            if root.left != None:
                dict[root.left.val] = [root.val, level + 1]
            if root.right != None:
                dict[root.right.val] = [root.val, level + 1]
            levelOrder(root.left, level + 1)
            levelOrder(root.right, level + 1)
        levelOrder(root, 1)
        if dict[x][0] != dict[y][0] and dict[x][1] == dict[y][1]:
            return True
        return False