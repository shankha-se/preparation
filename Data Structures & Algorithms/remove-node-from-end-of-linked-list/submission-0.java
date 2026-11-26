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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = getSize(head);
        int x = sz + 1 - n;
        if (x == 1) {
            return head.next;
        }
        ListNode curr = head;
        for (int i = 1; i < x - 1; i++){
            curr = curr.next;
        }
        ListNode tobeDeleted = curr.next;
        curr.next = tobeDeleted.next;
        tobeDeleted.next = null;
        return head;
    }

    private int getSize(ListNode head){
        int counter = 0;
        while(head != null){
            counter++;
            head = head.next;
        }
        return counter;
    }
}
