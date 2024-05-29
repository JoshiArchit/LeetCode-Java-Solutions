package Matrix.prb73;

import java.util.Arrays;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    public void setZeroes(int[][] matrix) {
        // markers for 0th row and 0th col
        boolean isRow = false;
        boolean isCol = false;

        // Check first column for zeroes and set marker
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                isCol = true;
                break;
            }
        }

        // Check first row for zeroes and set marker
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                isRow = true;
                break;
            }
        }

        // Iterate through the matrix and use markers
        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if( matrix[i][j] == 0) {
                    // Mark the first row of the jth column and first column of the ith row
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Final scan to set the corresponding row and columns to 0
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // Update first row and column if required
        if(isCol) {
            for(int i=0; i< matrix.length; i++){
                matrix[i][0]=0;
            }
        }
        if(isRow) {
            Arrays.fill( matrix[ 0 ], 0 );
        }
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        sol.setZeroes( matrix );
    }
}
