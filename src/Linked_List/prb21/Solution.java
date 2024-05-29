package Linked_List.prb21;
/**
  * BSTIterator.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

/**
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        // List 1 is empty, so return list 2.
        if( l1 == null ) {
            return l2;
        }
        // List 2 is empty, so return list 1.
        if( l2 == null ) {
            return l1;
        }
        // L1 element is smaller than L2 element
        if( l1.val < l2.val ) {
            // Recursively merge the rest of the list
            l1.next = mergeLists( l1.next, l2 );
            return l1;
        } else {
            // L2 element is smaller than L1 element
            // Recursively merge the rest of the list
            l2.next = mergeLists( l1, l2.next );
            return l2;
        }
    }
}
