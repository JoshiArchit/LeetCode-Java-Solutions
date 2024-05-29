package Math.prb860;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public boolean lemonadeChange(int[] bills) {

        int num5bills = 0;
        int num10bills = 0;

        for(int bill : bills) {
            if(bill == 5) {
                // Exact change was given
                num5bills += 1;
            } else if( bill == 10 ) {
                // Would need to return a 5 dollar bill
                if(num5bills==0) {
                    // No 5 bills remaining
                    return false;
                } else {
                    // Give a 5 bill and decrement count for 5, increase for 10
                    num5bills--;
                    num10bills++;
                }
            } else {
                // 20 bill was given, need to return 15, can be done two ways
                if((num5bills>=1) && (num10bills>=1)) {
                    // Can return 1 5s and 1 10, increment decrement accordingly
                    num5bills --;
                    num10bills--;
                }
                else if(num5bills>=3) {
                    // Can return 3 of the 5 bills and decrement 5, increment 20
                    num5bills = num5bills-3;
                } else {
                    // Cannot return change
                    return false;
                }
            }
        }

        return true;

    }

    public static void main( String[] args ) {
        Solution sol = new Solution();
        int[] bills = {5,5,5,5,10,5,10,10,10,20};
        System.out.println(sol.lemonadeChange( bills ));
    }
}
