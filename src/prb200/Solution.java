package prb200;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 */

class Solution {
    public int numIslands(char[][] grid) {
        // Iterate the grid and perform DFS, each DFS start is an island
        int islands = 0;
        // Check for empty grid
        if(grid==null||grid.length==0) {
            return islands;
        }

        // Perform grid search
        int rows = grid.length;
        int columns = grid[0].length;

        for(int r=0; r<rows; r++) {
            for(int c=0; c<columns; c++){
                if(grid[r][c]=='1'){
                    islands ++;
                    depthFS( r, c, grid );
                }
            }
        }

        return islands;
    }

    public void depthFS(int rows, int column, char[][] grid) {
        // Get num rows and num columns
        int col = grid[0].length;
        int row = grid.length;

        // Base case : The grid is just one cell, recursion is over
        if( column<0 || rows<0 || column >= col || rows >= row || grid[rows][column] == '0'){
            return;
        }

        // Otherwise mark as visited
        grid[rows][column] = '0';

        // Recursive calls to top, bottom, left, right
        depthFS( rows-1, column, grid);
        depthFS(rows+1, column, grid);
        depthFS(rows, column+1, grid);
        depthFS(rows, column-1, grid);

        return;
    }
}