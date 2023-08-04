class Solution {
    class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26];
        }
    }

    Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(var v : wordDict) insert(v);
        char[] c = s.toCharArray();
        int n = c.length;
        boolean[] dp = new boolean[n];
        for(int i = 0; i<n; i++) {
            if(i == 0 || dp[i - 1]) {
                Node node = root;
                for(int j = i; j<n; j++) {
                    if(node.children[c[j] - 'a'] == null) break;
                    node = node.children[c[j] - 'a'];
                    if(node.isEnd) dp[j] = true;
                }
            }
        }
        return dp[n - 1];
    }
}