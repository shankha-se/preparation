/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val;
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        for(int i = 1; i < left; i++){
            prev = prev.next;
        }

        ListNode rightNode = prev;
        for(int i = 0; i <= right - left; i++){
            rightNode = rightNode.next;
        }

        ListNode next = rightNode.next;
        rightNode.next = null;
        ListNode toBeReversed = prev.next;
        prev.next = null;

        ListNode reversed = reverse(toBeReversed);
        prev.next = reversed;
        ListNode reversedTail = getTail(reversed);
        reversedTail.next = next;

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private ListNode getTail(ListNode head) {
        ListNode curr = head;
        ListNode tail = null;
        while(curr != null){
            tail = curr;
            curr = curr.next;
        }
        return tail;
    }
}