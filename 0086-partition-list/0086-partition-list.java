/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode a = new ListNode(-1), b = new ListNode(-1);
        ListNode m = a, n = b;
        while(head != null) {
            if(head.val < x) {
                m.next = new ListNode(head.val);
                m = m.next;
            }
            else {
                n.next = new ListNode(head.val);
                n = n.next;
            }
            head = head.next;
        }
        if(b.next != null) m.next = b.next;
        return a.next;
    }
}