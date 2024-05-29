package psb2303;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

/**
 * Input: brackets = [[3,50],[7,10],[12,25]], income = 10
 * Output: 2.65000
 * Explanation:
 * Based on your income, you have 3 dollars in the 1st tax bracket, 4 dollars in the 2nd tax bracket, and 3 dollars in the 3rd tax bracket.
 * The tax rate for the three tax brackets is 50%, 10%, and 25%, respectively.
 * In total, you pay $3 * 50% + $4 * 10% + $3 * 25% = $2.65 in taxes.
 */

class Solution {
    public double calculateTax(int[][] brackets, int income) {

        double total = 0;
        double upper_i = 0;
        // Iterate through each bracket
        for( int[] bracket : brackets) {
            if(bracket[0] > income){
                // Set the correct difference if amount is higher than income
                bracket[0] = bracket[0]-(bracket[0]-income);
            }
            upper_i = bracket[0]-upper_i;

            total = total+((upper_i*bracket[1])/100);
            upper_i = bracket[0];
        }
        return total;

    }

    public static void main( String[] args ) {
        int[][] bracket = {{3, 50}, {7,10}, {12, 25}};
        int income = 10;

        Solution sol = new Solution();
        double outcome = sol.calculateTax( bracket, income );
        System.out.println(outcome);
    }
}