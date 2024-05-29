package Matrix.prb54;

import java.util.ArrayList;
import java.util.List;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public List<Integer> spiralOrder( int[][] matrix) {
        // Describe initialisations
        int r = 0; // Start row index
        int c = 0; // Start column index
        int re = matrix.length-1; // End row index
        int ce = matrix[0].length-1;

        List<Integer> order = new ArrayList<>();
        recurseTravel(order, matrix, r, c, re, ce) ;
        return order;
    }

    public void recurseTravel( List< Integer > order, int[][]matrix, int row_start, int col_start, int row_end, int col_end) {
        // Base case: check if indices are valid
        if (row_start > row_end || col_start > col_end) {
            return;
        }

        // Add top row from left to right
        for (int i = col_start; i <= col_end; i++) {
            order.add(matrix[row_start][i]);
        }
        row_start++;

        // Add right column from top to bottom
        for (int i = row_start; i <= row_end; i++) {
            order.add(matrix[i][col_end]);
        }
        col_end--;

        // Add bottom row from right to left if there are rows remaining
        if (row_start <= row_end) {
            for (int i = col_end; i >= col_start; i--) {
                order.add(matrix[row_end][i]);
            }
            row_end--;
        }

        // Add left column from bottom to top if there are columns remaining
        if (col_start <= col_end) {
            for (int i = row_end; i >= row_start; i--) {
                order.add(matrix[i][col_start]);
            }
            col_start++;
        }

        // Recursive call for the inner spiral
        recurseTravel(order, matrix, row_start, col_start, row_end, col_end);
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> order;
        order = sol.spiralOrder( matrix );
        System.out.println(order);
    }
}