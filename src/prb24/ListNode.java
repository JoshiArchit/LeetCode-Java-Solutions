package prb24;

import java.util.List;

/**
  * Linked_List.prb445.ListNode.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class ListNode {
    int val;
    ListNode next;

    ListNode () {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val;this.next = next;}

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        Linked_List.prb445.ListNode current = this;
//        while (current != null) {
//            sb.append(current.val).append(" -> ");
//            current = current.next;
//        }
//        sb.append("null");
//        return sb.toString();
//    }
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
