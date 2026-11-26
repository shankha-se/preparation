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
        if(head == null){
            return head;
        }
        head = attachDuplicateNodes(head);
        head = copyRandomPointers(head);
        Node newNode = constructSeperateList(head);
        return newNode;
    }

    private Node attachDuplicateNodes(Node head){
        Node curr = head;
        
        while(curr != null){
            Node forward = curr.next;
            Node currCopy = new Node(curr.val);
            curr.next = currCopy;
            currCopy.next = forward;

            curr = forward;
        }
        return head;
    }

    private Node copyRandomPointers(Node head){
        Node curr = head;
        
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        return head;
    }

    private Node constructSeperateList(Node head){
        Node dummy = new Node(1);
        Node prev = dummy;
        Node curr = head;

        while(curr != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;

            prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
