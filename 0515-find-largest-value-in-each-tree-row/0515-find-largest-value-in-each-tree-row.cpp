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
    vector<int> largestValues(TreeNode* root) {
        vector<int> ans;
        function<void(TreeNode*, int)> levelOrder = [&](TreeNode* root, int level) {
            if(!root) return;
            if(level >= ans.size()) ans.push_back(root->val);
            else if(root->val > ans[level]) ans[level] = root->val;
            levelOrder(root->left, level + 1);
            levelOrder(root->right, level + 1);
        };
        levelOrder(root, 0);
        return ans;
    }
};