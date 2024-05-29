package Simulation.prb1041;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] init = {0, 0};
        List<Character> instruction_list = instructions.chars().mapToObj( c -> ( char ) c ).toList();
        int axis = 1; // 1 says y-axis
        int direction = 1; // says north
        // Create a list of instructions
        ArrayList<int[]> moves = new ArrayList<>();
        int[] current = init;
        for(char inst : instruction_list) {
            if(inst == 'G') {
                // move robot 1 unit based on axis and direction
                if(axis == 1) {
                    if(direction == 1) {
                        current = new int[]{current[0], current[1] + 1};
                    } else if(direction == 2) {
                        current = new int[]{current[0] + 1, current[1]};
                    } else if(direction == 3) {
                        current = new int[]{current[0], current[1] - 1};
                    } else {
                        current = new int[]{current[0] - 1, current[1]};
                    }
                } else {
                    if(direction == 1) {
                        current = new int[]{current[0] + 1, current[1]};
                    } else if(direction == 2) {
                        current = new int[]{current[0], current[1] - 1};
                    } else if(direction == 3) {
                        current = new int[]{current[0] - 1, current[1]};
                    } else {
                        current = new int[]{current[0], current[1] + 1};
                    }
                }
            } else if (inst == 'L') {
                // change direction to left
                direction = (direction + 3) % 4;
            } else {
                // change direction to right
                direction = (direction + 1) % 4;
            }
        }

        // Check what the final direction is, if it is not north, then the robot will return to the initial position
        return direction != 1 || Arrays.equals(init, current);
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();
        String instructions = "GL";
        boolean result = sol.isRobotBounded( instructions );
        System.out.println(result);
    }
}