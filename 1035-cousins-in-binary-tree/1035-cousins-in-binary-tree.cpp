/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    map<int, pair<int, int>> mp;
    bool isCousins(TreeNode* root, int x, int y) {
        if(!root) return 0;
        mp[root->val] = {-1, 0};
        levelOrder(root, 1);
        return mp[x].first != mp[y].first and mp[x].second == mp[y].second;
    }
    void levelOrder(TreeNode* root, int level) {
        if(!root) return;
        if(root->left != NULL) mp[root->left->val] = {root->val, level};
        if(root->right != NULL) mp[root->right->val] = {root->val, level};
        levelOrder(root->left, level + 1);
        levelOrder(root->right, level + 1);
    }
};