package prb945;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
//    // Naive approach
//    public int[] sortArrayByParity(int[] nums) {
//        // Create a new array that will store nums as you parse them, store if they are even
//        // int[] new_array = new int[nums.length];
//        ArrayList<Integer> new_array= new ArrayList<Integer>();
//
//        // Traverse through nums and add number to new_array if its even
//        for(int num : nums) {
//            // Check if even
//            if(num%2==0) {
//                new_array.add(0, num );
//            }else {
//                new_array.add(num);
//            }
//        }
//        int[] result = new int[new_array.size()];
//        for (int i = 0; i < new_array.size(); i++) {
//            result[i] = new_array.get(i);
//        }
//
//        return result;
//
//    }

    // In-place using quicksort
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if(nums[i]%2 > nums[j]%2) {
                //odd stands before even, swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }

            // Increment pointers based on what number it was
            if(nums[i]%2==0) {i++;}
            if(nums[j]%2==1) {j--;}
        }

        return nums;
    }

    public static void main( String[] args ) {
        int[] nums = {0,1,2};
        Solution sol = new Solution();
        System.out.println( Arrays.toString( sol.sortArrayByParity( nums ) ) );
    }
}
