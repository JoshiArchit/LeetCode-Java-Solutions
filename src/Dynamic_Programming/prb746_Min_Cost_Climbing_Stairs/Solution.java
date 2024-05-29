package Dynamic_Programming.prb746_Min_Cost_Climbing_Stairs;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Create a cost+1 size array
        int[] dp = new int[cost.length+1];

        for(int i = 2; i<dp.length; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2] );
        }

        return dp[dp.length-1];
    }

    public static void main( String[] args ) {
        int[] cost = {10, 15, 20};
        int minimum = new Solution().minCostClimbingStairs( cost );
    }
}