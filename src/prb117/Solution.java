package prb117;

import java.util.LinkedList;
import java.util.Queue;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null; // Track the previous node in the current level

            for (int i = 0; i < size; i++) {
                Node node = queue.remove();

                if (prev != null) {
                    prev.next = node;
                }
                prev = node;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

    public static void main( String[] args ) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(7);
        node1.left = node2; node1.right=node3;
        node2.left = node4; node2.right=node5;
        node3.right = node6;
        node1.next = null;
        node2.next = null;
        node3.next = null;
        node4.next = null;
        node5.next = null;
        node6.next = null;

        Solution sol = new Solution();
        sol.connect( node1 );
    }
}
