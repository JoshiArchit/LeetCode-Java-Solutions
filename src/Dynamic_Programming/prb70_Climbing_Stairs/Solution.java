package Dynamic_Programming.prb70_Climbing_Stairs;

import java.util.ArrayList;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];

        // Base cases - Can take only 1 or 2 steps at a time
        dp[0] = 0;
        // Can take 1 step only one way
        dp[1] = 1;
        if(n>=2){
            // Can take 2 steps two ways -> 1 + 1 or 2
            dp[2] = 2;
        }
        // Recurrence relation : x = (x-1) + (x-2)
        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    public static void main( String[] args ) {
        int n = 1;
        int step = new Solution().climbStairs( n );
        System.out.println(step);
    }
}