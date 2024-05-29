package prb55;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
enum Index {
    G, B, U;
}
class Solution {
    Index memo[];

    public boolean canJumpFrom(int position, int[] nums) {
        // Base case. Return if good or bad
        if(memo[position] != Index.U) {
            return memo[ position ] == Index.G;
        }

        int longestJump = Math.min(position+nums[position], nums.length-1);
        for(int nextPosition=position+1; nextPosition<=longestJump; nextPosition++){
            if(canJumpFrom(nextPosition, nums)){
                memo[nextPosition] = Index.G;
                return true;
            }
        }

        memo[position] = Index.B;
        return false;
    }

    public boolean canJump(int[] nums) {
        // Set everything to U except last which is G
        memo = new Index[nums.length];
        for(int i=0; i< nums.length; i++){
            memo[i] = Index.U;
        }
        memo[ memo.length-1] = Index.G;
        return canJumpFrom(0, nums);
    }

    public static void main( String[] args ) {
        int[] nums = {2,3,1,1,4};
        Solution sol = new Solution();
        boolean result = sol.canJump( nums );
        System.out.println(result);
    }
}