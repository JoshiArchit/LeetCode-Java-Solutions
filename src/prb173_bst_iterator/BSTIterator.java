package prb173_bst_iterator;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    // Use a stack to store the nodes in the path from the root to the current node.
    // The top of the stack is the current node.
    Stack<TreeNode> stack = new Stack<TreeNode>();


    public BSTIterator(TreeNode root) {
        pushItem( root );
    }

    public int next() {
        TreeNode node = stack.pop();
        pushItem(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushItem(TreeNode node) {
        // Push the leftmost node of the current node.
        while( node != null ) {
            stack.push( node );
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */