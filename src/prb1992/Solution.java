package prb1992;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public int[][] findFarmland(int[][] land) {

        // Perform grid search
        int rows = land.length;
        int columns = land[0].length;
        ArrayList<int[]> lands = new ArrayList<>();

        for(int r=0; r<rows; r++) {
            for(int c=0; c<columns; c++){
                if(land[r][c]==1){
                    int[] boundaries = {r, c, r, c};
                    lands.add(depthFS( r, c, land, boundaries ));
                }
            }
        }
        // Convert to int[][]
        return lands.toArray( new int[ 0 ][] );

    }

    public int[] depthFS(int rows, int column, int[][] grid, int[] boundaries) {
        // Get num rows and cols
        int col = grid[0].length;
        int row = grid.length;

        // For out of bound the boundary remains the same
        if (rows < 0 || rows >= row || column < 0 || column >= col) {
            // Return the starting coordinate of the current plot of farmland
            return new int[]{boundaries[0], boundaries[1]};
        }

        // If the current cell is not farmland, return the current coordinate
        if (grid[rows][column] == 0) {
            return new int[]{rows, column};
        }

        // Mark as visited
        grid[rows][column] = 0;

        // Update boundaries
        boundaries[2] = Math.max(boundaries[2], rows); // Update the maximum row
        boundaries[3] = Math.max(boundaries[3], column); // Update the maximum column

        // Recursive calls to neighbors get all corners
        int[] left = depthFS( rows-1, column, grid, boundaries );
        int[] right = depthFS(rows+1, column, grid, boundaries);
        int[] top = depthFS(rows, column+1, grid, boundaries);
        int[] bottom = depthFS(rows, column-1, grid, boundaries);

        return boundaries;
    }

    public static void main( String[] args ) {
        int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
        Solution sol = new Solution();
        int[][] result = sol.findFarmland( land );
        System.out.println( Arrays.deepToString( result ) );

    }
}