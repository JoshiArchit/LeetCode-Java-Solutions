package Binary_Tree.prb111;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public int minDepth(TreeNode root) {
        return recurseTrav(root );
    }

    public int recurseTrav(TreeNode root) {
        // No node , return 0
        if(root == null) {
            return 0;
        }
        // Leaf node, return 1
        if(root.left == null && root.right == null) {
            return 1;
        }
        // Left is empty, recurse only right
        if(root.left == null) {
            return recurseTrav(root.right) + 1;
        }
        // Right is empty, recurse only left
        else if(root.right == null) {
            return recurseTrav(root.right) + 1;
        }

        // Traverse left and get depth
        int nodes_l = recurseTrav( root.left );
        // Traverse right and get depth
        int nodes_r = recurseTrav( root.right );

        // Count the max depth
        return Math.min(nodes_l, nodes_r) + 1;
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        // Create the nodes
        TreeNode node1 = new TreeNode(1);

        // Link the nodes to form the tree
        node1.right = new TreeNode(2);

        Solution sol = new Solution();
        System.out.println(sol.minDepth( node1 ));
    }
}