package Math.prb1491;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public double average(int[] salary) {
        // Start with min max set to first value
        int min = salary[0];
        int max = salary[1];
        // Count for average
        double count = 0;
        // Total
        double total = 0;

        // Iterate through the values and update the min max accordingly
        for(int sal : salary) {
            if(sal >= max) {
                max = sal;
            }
            if(sal <= min) {
                min = sal;
            }
        }

        // Final pass to get average and exclude min max
        for(int sal : salary) {
            if(!(sal == min) && !(sal == max)) {
                System.out.println(sal);
                total += sal;
                count += 1;
            }
        }

        System.out.println("Minimum : " +min);
        System.out.println("Maximum : "+max);

        return total/count;
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();
        int[] salary = {8000,9000,2000,3000,6000,1000};
        double average = sol.average( salary );
        System.out.println("Average :  "+ average);

    }


}