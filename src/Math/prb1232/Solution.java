package Math.prb1232;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Return true if its just 2 points
        if(coordinates.length < 2) {
            return true;
        }

        // Get deltas from first point
        double deltaX = coordinates[1][0] - coordinates[0][0];
        double deltaY = coordinates[1][1] - coordinates[0][1];

        // Check if consecutive slopes are equal starting from point 1 to last point
        for(int i = 1; i < coordinates.length-1; i++) {
            if(((coordinates[i+1][1] - coordinates[i][1])*deltaX) != ((coordinates[i+1][0]-coordinates[i][0])*deltaY)) {
                return false;
            }
        }
        return true;
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();
//        int[][] points = {
//                {1, 2},
//                {2, 3},
//                {3, 4},
//                {4, 5},
//                {5, 6},
//                {6, 7}
//        };

        //[[0,0],[0,5],[5,5],[5,0]]
        int[][] points = {
                {0,0},
                {0,5},
                {5,5},
                {5,0}
        };

        System.out.println(sol.checkStraightLine( points ));
    }
}