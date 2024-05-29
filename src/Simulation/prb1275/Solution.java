package Simulation.prb1275;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag1 = 0;
        int diag2 = 0;
        int player = 1;

        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];

            rows[row] += player;
            cols[col] += player;

            if (row == col) {
                diag1 += player;
            }

            if (row + col == n - 1) {
                diag2 += player;
            }

            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag1) == n || Math.abs(diag2) == n) {
                return player == 1 ? "A" : "B";
            }

            player *= -1;
        }

        return moves.length == n * n ? "Draw" : "Pending";
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();
        int[][] moves = {
                {0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}
        };

        String result = sol.tictactoe( moves );
        System.out.println(result);
    }
}