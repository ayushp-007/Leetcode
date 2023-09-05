/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node ans = new Node(-1), temp = head, temp2 = ans;
        Map<Node, Node> map = new HashMap<>(); 
        while(temp != null) {
            temp2.next = new Node(temp.val);
            temp2 = temp2.next;
            map.put(temp, temp2);
            temp = temp.next;
            
        }
        temp = head;
        temp2 = ans.next;
        while(temp != null) {
            temp2.random = map.get(temp.random);
            temp = temp.next;
            temp2 = temp2.next;
        }
        return ans.next;
    }
}