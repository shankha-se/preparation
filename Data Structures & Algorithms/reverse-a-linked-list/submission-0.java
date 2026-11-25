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
    public ListNode reverseList(ListNode head) {
        int size = getSize(head);
        int left = 0;
        int right = size - 1;

        while(left <= right){
            ListNode leftNode = getNodeAt(head, left);
            ListNode rightNode = getNodeAt(head, right);

            //Swap
            int temp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;

            left ++;
            right --;
        }
        return head;
    }

    public ListNode getNodeAt(ListNode head, int position){
        ListNode temp = head;
        for(int i = 1; i <= position; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int getSize(ListNode head) {
        if (head == null){
            return 0;
        }
        int counter = 0;
        ListNode temp = head;
        while(temp != null){
            counter ++;
            temp = temp.next;
        }
        return counter;
    }
}
