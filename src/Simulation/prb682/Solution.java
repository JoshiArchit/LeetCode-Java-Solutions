package Simulation.prb682;

import java.util.Stack;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    public int calcPoints(String[] operations) {
        // Create stack
        Stack<Integer> stack = new Stack<>();

        for(String operation : operations) {
            if(operation.equals( "+" )) {
                // Pop the top and sum it with the new top
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top); // Insert top again
                stack.push( newtop ); // Insert sum of last two
            } else if(operation.equals("C")) {
                // Discard last inserted element (pop)
                stack.pop();
            } else if(operation.equals("D")) {
                // Insert double the sum of top
                stack.add( 2*stack.peek());
            } else {
                // Its an integer, convert to int and add
                stack.push(Integer.valueOf( operation ));
            }
        }

        // Sum the stack
        int sum = 0;
        for(int number : stack) {
            sum += number;
        }

        return sum;
    }
//    public int calcPoints(String[] operations) {
//        // Create array list that will store scores
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        int arrayPointer = 0;
//
//        // Iterate through the operations array and perform action
//        for( String instruction : operations) {
//            try {
//                int num = Integer.parseInt( instruction );
//                arr.add( num );
//                arrayPointer = arr.size()-1;
//            }
//            catch(NumberFormatException e){
//                // Double score
//                if( instruction.equals( "D" ) ) {
//                    arr.add( 2* arr.get( arrayPointer ) );
//                    arrayPointer = arr.size()-1;
//                }
//                // Revoke action
//                else if( instruction.equals("C")) {
//                    arr.remove( arr.get(arrayPointer) );
//                    arrayPointer--;
//                }
//                // Add last two
//                else if( instruction.equals( "+" )) {
//                    arr.add( arr.get( arrayPointer ) + arr.get(arrayPointer-1) );
//                    arrayPointer = arr.size()-1;
//                }
//            }
//
//        }
//
//        return arr.stream().mapToInt( Integer::intValue ).sum();
//    }

    public static void main( String[] args ) {
        String[] list = {"5", "2", "C", "D", "+"};
        Solution sol = new Solution();
        int score = sol.calcPoints( list );
        System.out.println(score);
    }
}
