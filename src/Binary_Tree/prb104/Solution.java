package Binary_Tree.prb104;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public int maxDepth(TreeNode root) {
        int depth = recurseTrav(root );

        return depth;
    }

    public int recurseTrav(TreeNode root) {
        // No node , return 0
        if(root == null) {
            return 0;
        }

        // Traverse left and get depth
        int depth_l = recurseTrav( root.left );
        int depth_r = recurseTrav( root.right );

        return Math.max(depth_l, depth_r)+1;

    }
}