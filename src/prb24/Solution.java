package prb24;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // return head if list empty
        if(head == null || head.next == null){
            return head;
        }

        // Create a dummy pointer to first node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Loop until there is a pair left
        while( current.next != null && current.next.next != null) {
            // Set up the chain
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;
            ListNode thirdNode = current.next.next.next;

            current.next = secondNode;
            firstNode.next = thirdNode;
            secondNode.next = firstNode;

            current = firstNode;
        }

        return dummy.next;

    }

    public static void main( String[] args ) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        System.out.println(node1);
        Solution sol = new Solution();
        ListNode head = sol.swapPairs( node1 );
        System.out.println(head);

    }
}
