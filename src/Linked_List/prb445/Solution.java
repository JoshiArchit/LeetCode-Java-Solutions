package Linked_List.prb445;

import java.util.Stack;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create two stacks to store lists
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int carry = 0;

        // Traverse both lists and add elements to respective stacks
        while(l1 != null) {
            stack1.push( l1.val );
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        // dummy start node
        ListNode start = new ListNode(0);
        ListNode curr = start;
        // Pop each element and add them, the lesser significant number is
        // always at the top
        while(stack1.size()!=0 || stack2.size() != 0 || carry!=0) {
            int x = (stack1.size()!=0) ? stack1.pop() : 0;
            int y = (stack2.size()!= 0) ? stack2.pop() : 0;

            // Add numbers and extract carry if any
            int sum = x+y+carry;
            carry = sum/10;

            curr.next = new ListNode(sum%10);
            curr = curr.next;
        }

        // Reverse list recursively

        return reverseList( start.next );
    }

    public ListNode reverseList(ListNode head) {
        // No nodes
        if(head==null) {
            return head;
        }
        // Only one node left, return it
        if(head.next==null){
            return head;
        }

        // else call reverse on head.next
        ListNode node = reverseList( head.next );
        head.next.next = head;
        head.next = null;

        return node;
    }

    // Helper method to print a linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating linked list l1: [7, 2, 4, 3]
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        // Creating linked list l2: [5, 6, 4]
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Printing the lists to verify
        printList(l1); // Should print: 7 -> 2 -> 4 -> 3
        printList(l2); // Should print: 5 -> 6 -> 4

        // Test
        Solution sol = new Solution();
        ListNode l3 = sol.addTwoNumbers( l1, l2 );
    }
}
