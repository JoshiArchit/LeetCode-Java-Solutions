package prb1137;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    public int tribonacci(int n) {
        if(n < 3) {
            return n == 0 ? 0 : 1;
        }
        int t0 = 0, t1 = 1, t2 = 1;

        for(int i = 3; i <= n; i++) {
            int temp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = temp;
        }

        return t2;
    }
}
