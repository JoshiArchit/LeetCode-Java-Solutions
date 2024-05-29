package Binary_Tree.prb94;

import java.util.ArrayList;
import java.util.List;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        traverseInorder(order, root);
        return order;
    }

    public void traverseInorder(List<Integer> order, TreeNode root) {
        // Base case - node is null
        if(root == null) {
            return;
        }
//        // Root left and right is null (leaf)
//        if(root.left == null && root.right == null) {
//            order.add( root.val );
//        }

        // Traverse left
        traverseInorder( order, root.left );
        // Add root
        order.add(root.val);
        // Traverse Right
        traverseInorder(order, root.right);
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        // Link the nodes to form the tree
        node1.right = node2;
        node2.left = node3;

        List<Integer> order = sol.inorderTraversal( node1 );

        // Print
        System.out.println(order);
    }

}
