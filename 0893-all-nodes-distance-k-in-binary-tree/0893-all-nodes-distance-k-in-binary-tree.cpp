/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    map<int, vector<int>> mp;
    vector<int> ans;
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        dfs(root);
        bfs(target->val, k);
        return ans;
    }
    void dfs(TreeNode* root) {
        if(!root) return;
        if(root->left != NULL) {
            mp[root->val].push_back(root->left->val);
            mp[root->left->val].push_back(root->val);
        }
        if(root->right != NULL) {
            mp[root->val].push_back(root->right->val);
            mp[root->right->val].push_back(root->val);
        }
        dfs(root->left);
        dfs(root->right);
    }
    void bfs(int target, int k) {
        queue<int> q;
        q.push(target);
        int cnt = 0;
        unordered_set<int> vis;
        vis.insert(target);
        while(!q.empty()) {
            int n = q.size();
            if(cnt > k) break;
            for(int i = 0; i<n; i++) {
                int node = q.front();
                q.pop();
                if(cnt == k) ans.push_back(node);
                for(int i : mp[node]) {
                    if(!vis.count(i)) {
                        q.push(i);
                        vis.insert(i);
                    }
                }
            }
            cnt++;
        }
    }
};