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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(var i : nums) set.add(i);
        int cnt = 0;
        boolean b = false;
        while(head != null) {
            if(!set.contains(head.val)) {
                b = false;
                head = head.next;
            }
            else if(!b) {
                b = true;
                head = head.next;
                cnt++;
            }
            else if(b) {
                head = head.next;
            }
        }
        return cnt;
    }
}