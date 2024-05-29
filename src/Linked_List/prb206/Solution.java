package Linked_List.prb206;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public ListNode reverseList(ListNode head) {
        // Only one node left, return it
        if(head.next==null){
            return head;
        }
        // No nodes
        if(head==null) {
            return head;
        }

        // else call reverse on head.next
        ListNode node = reverseList( head.next );
        head.next.next = head;
        head.next = null;

        return node;
    }
}