package prb653;
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

// Solution 1 : using HashSet
// Time Complexity : O(n), where n is the number of nodes in the tree.
// Space Complexity : O(n), where n is the number of nodes in the tree.

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set );
    }

    public boolean find(TreeNode root, int k, Set<Integer> set) {
        // Base Case
        // Empty tree return null
        if (root == null) {
            return false;
        }
        // Set contains the difference required for the sum
        if (set.contains( k-root.val )) {
            return true;
        }

        // Recursively check
        set.add( root.val );
        return find(root.left, k, set) || find(root.right, k, set);

    }
}