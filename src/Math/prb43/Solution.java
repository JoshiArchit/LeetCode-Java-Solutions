package Math.prb43;

import java.math.BigInteger;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public String multiply(String num1, String num2) {
        BigInteger a = new BigInteger( num1 );
        BigInteger b = new BigInteger( num2 );

        BigInteger c = a.multiply( b );

        return c.toString();
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();
        String num1 = "123456789";
        String num2 = "987654321";
        String result = sol.multiply( num1, num2 );
        System.out.println(result);

    }
}