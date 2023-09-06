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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = size(head);
        ListNode[] ans = new ListNode[k];
        if(n < k) {
            for(int i = 0; i<n; i++) {
                ListNode temp = new ListNode(head.val);
                ans[i] = temp;
                head = head.next;
            }
        }
        else {
            int q = n / k, r = n % k;
            for(int i = 0; i < k; i++) {
                ListNode temp = new ListNode(-1), temp1 = temp;
                for(int j = 0; j < q; j++) {
                    temp1.next = new ListNode(head.val);
                    temp1 = temp1.next;
                    head = head.next;
                }
                if(r > 0) {
                    r--;
                    temp1.next = new ListNode(head.val);
                    temp1 = temp1.next;
                    head = head.next;
                }
                ans[i] = temp.next;
            }
        }
        return ans;
    }
    public int size(ListNode head) {
        if(head == null) return 0;
        return 1 + size(head.next);
    }
}