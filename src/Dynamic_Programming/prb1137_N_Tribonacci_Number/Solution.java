package Dynamic_Programming.prb1137_N_Tribonacci_Number;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
//    public int tribonacci(int n) {
//        if(n < 3) {
//            return n == 0 ? 0 : 1;
//        }
//        int t0 = 0, t1 = 1, t2 = 1;
//
//        for(int i = 3; i <= n; i++) {
//            int temp = t0 + t1 + t2;
//            t0 = t1;
//            t1 = t2;
//            t2 = temp;
//        }
//
//        return t2;
//    }

    // Memoization approach
    public int tribonacci(int n){
        // Create array of size n+1
        int[] tribo = new int[n+1];

        // Base case
        tribo[0] = 0;
        if(n>=1){
            tribo[1] = 1;
        }
        if(n>=2) {
            tribo[2] = 1;
        }
        if(n>=3) {
            tribo[3] = 2;
        }
        if(n<=3) {
            return tribo[n];
        }

        // Recurrence - tribo[i] = tribo[i-1] + tribo[i-2] + tribo[i-3]
        for(int i =4; i<=n; i++){
            tribo[i] = tribo[i-1] + tribo[i-2] + tribo[i-3];
        }

        return tribo[n];
    }
}