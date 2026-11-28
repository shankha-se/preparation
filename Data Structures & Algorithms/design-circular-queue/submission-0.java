class ListNode {
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class MyCircularQueue {
    private int space;
    private ListNode left;
    private ListNode right;

    public MyCircularQueue(int k) {
        this.space = k;
        this.left = new ListNode(0);
        this.right = this.left;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        ListNode cur = new ListNode(value);
        if (isEmpty()) {
            this.left.next = cur;
            this.right = cur;
        }
        else {
            this.right.next = cur;
            this.right = cur;
        }
        this.space--;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.left.next = this.left.next.next;
        if (isEmpty()) {
            this.right = this.left;
        }
        this.space++;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return this.left.next.val;
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return this.right.val;
    }
    
    public boolean isEmpty() {
        return this.left.next == null;
    }
    
    public boolean isFull() {
        return this.space == 0;
    }
}
