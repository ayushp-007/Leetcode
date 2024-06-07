class Solution {
    class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26];
        }
    }

    Node root;

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


    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Node();
        for(var i : dictionary) insert(i);
        String[] s = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        outer : for(var v : s) {
            StringBuilder temp = new StringBuilder();
            Node curr = root;
            boolean ok = false;
            for(char c : v.toCharArray()) {
                
                if(curr.isEnd == true) {
                    ok = true;
                    ans.append(temp);
                    ans.append(" ");
                    continue outer;
                }
                if(curr.children[c - 'a'] == null) break;
                curr = curr.children[c - 'a'];
                temp.append(c);
            }
            ans.append(v);
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}