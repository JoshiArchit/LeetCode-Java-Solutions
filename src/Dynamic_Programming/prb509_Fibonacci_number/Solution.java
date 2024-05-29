package Dynamic_Programming.prb509_Fibonacci_number;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    public int fib(int n){
        // Create array of size n
        int[] fib = new int[n+1];

        // Base cases
        // Fib of 0 is 0
        fib[0] = 0;
        // Fib of 1 is 1
        if(n>=1) {
            fib[1] = 1;
        }
        if(n>=2){
            fib[2] = 1;
        }

        if(n<3){
            return fib[n];
        }

        // Recurrence - fib[i] = fib[i-1] + fib[i-2]
        for(int i=3; i<=n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public static void main( String[] args ) {
        int n = 3;
        int fib = new Solution().fib( n );
        System.out.println(fib);
    }
}
