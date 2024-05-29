package prb623;

/**
 * Definition for a binary tree node.
 * public class prb623.TreeNode {
 *     int val;
 *     prb623.TreeNode left;
 *     prb623.TreeNode right;
 *     prb623.TreeNode() {}
 *     prb623.TreeNode(int val) { this.val = val; }
 *     prb623.TreeNode(int val, prb623.TreeNode left, prb623.TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
