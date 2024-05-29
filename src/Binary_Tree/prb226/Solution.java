package Binary_Tree.prb226;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    public List<Integer> traverse(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        if (root == null) {
            return order;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            order.add(current.val);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return order;
    }

    // Invert tree
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    public TreeNode invert( TreeNode node) {
        // Base case - no node
        if(node == null) {
            return node;
        }

        // Recurse and get nodes
        TreeNode left_node = invert(node.left);
        TreeNode right_node = invert(node.right);

        node.left = right_node;
        node.right = left_node;

        return node;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    // Helper function to print the level order traversal
    public void printLevelOrder(List<List<Integer>> result) {
        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        List<Integer> order = sol.traverse( node1 );
        System.out.println(order);

        TreeNode root = sol.invertTree( node1 );

        List<List<Integer>> result = sol.levelOrder(root);
        sol.printLevelOrder(result);





    }
}
