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
    ListNode left;
    boolean stop = false;
    public void reorderList(ListNode head) {
        left = head;
        reorderHelper(head);
    }

    private void reorderHelper(ListNode right){
        if(right == null){
            return;
        }
        reorderHelper(right.next);

        if(stop){
            return;
        }
        if (left == right || left.next == right) {
            right.next = null;
            stop = true;
            return;
        }

        ListNode temp = left.next;
        right.next = temp;
        left.next = right;
        left = temp;
    }
}