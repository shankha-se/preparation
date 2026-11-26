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
        ListNode toBeReversed = prev.next;

        // Reverse the sublist directly
        ListNode reversed = null;
        ListNode curr = toBeReversed;

        while(curr != next){
            ListNode temp = curr.next;
            curr.next = reversed;
            reversed = curr;
            curr = temp;
        }

        prev.next = reversed;

        toBeReversed.next = next;
        return dummy.next;
    }
}