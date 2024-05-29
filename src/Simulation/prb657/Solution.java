package Simulation.prb657;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public boolean judgeCircle(String moves) {
        // Variables to represent x and y coordinates
        int x = 0;
        int y = 0;

        // Convert to char array
        char[] movesChar = moves.toCharArray();

        for(char move : movesChar) {
            if( move == 'U') {
                y++;
            } else if(move == 'D') {
                y--;
            } else if(move == 'L') {
                x++;
            } else {
                x--;
            }
        }

        return (x==0&&y==0);
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();
        String s = "LL";
        System.out.println(sol.judgeCircle( s ));

    }
}