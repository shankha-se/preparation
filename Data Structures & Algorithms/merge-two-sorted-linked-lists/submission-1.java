class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode resHead = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                resHead.next = list1;
                list1 = list1.next;
            }
            else {
                resHead.next = list2;
                list2 = list2.next;
            }
            resHead = resHead.next;
        }

        if(list1 != null){
            resHead.next = list1;
        }

        if(list2 != null){
            resHead.next = list2;
        }
        return dummy.next;
    }
}