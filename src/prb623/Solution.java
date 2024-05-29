package prb623; /**
  * prb623.Prb623.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

/**
 * Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
 *
 * Note that the root node is at depth 1.
 *
 * The adding rule is:
 *
 * Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
 * cur's original left subtree should be the left subtree of the new left subtree root.
 * cur's original right subtree should be the right subtree of the new right subtree root.
 * If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 */

public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // If depth is 1, then we need to add a new root node with the given
        // value and the original tree as its left child.
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        // Otherwise, we need to add the new nodes at the given depth.
        addOneRow(root, val, depth, 1);
        return root;
    }

    private void addOneRow(TreeNode root, int val, int depth, int currentDepth) {
        // If the root is null, then we have reached the end of the tree.
        if (root == null) {
            return;
        }
        // If the current depth is one less than the given depth,
        // then we need to add the new nodes.
        if (currentDepth == depth - 1) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return;
        }
        addOneRow(root.left, val, depth, currentDepth + 1);
        addOneRow(root.right, val, depth, currentDepth + 1);
    }
}

