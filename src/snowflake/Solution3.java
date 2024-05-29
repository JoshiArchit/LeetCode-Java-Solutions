package snowflake;

import java.util.*;

/**
  * Solution3.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution3 {
    public static int minimumDivision(List<Integer> a, List<Integer> b, int k) {
        int n = a.size();
        List<int[]> intervals = new ArrayList<>();

        // Add existing intervals to the list
        for (int i = 0; i < n; i++) {
            intervals.add(new int[]{a.get(i), b.get(i)});
        }

        // Sort intervals based on their start point
        Collections.sort(intervals, Comparator.comparingInt( o -> o[0]));

        int minSets = Integer.MAX_VALUE;

        // Try adding a segment between every pair of adjacent intervals
        for (int i = 0; i < n; i++) {
            int[] curr = intervals.get(i);
            int[] next = i < n - 1 ? intervals.get(i + 1) : null;

            // Calculate the potential segment to be added
            int aVal = curr[1] + 1;
            int bVal = next != null ? next[0] - 1 : Integer.MAX_VALUE;

            // Check if the segment satisfies the condition
            if (bVal - aVal + 1 <= k) {
                List<int[]> modifiedIntervals = new ArrayList<>(intervals);
                modifiedIntervals.add(i + 1, new int[]{aVal, bVal});
                minSets = Math.min(minSets, connectedSets(modifiedIntervals));
            }
        }

        return minSets;
    }

    // Helper function to calculate the minimum number of connected sets
    private static int connectedSets( List<int[]> intervals) {
        int count = 0;
        int end = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] > end) {
                count++;
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 6, 7, 16);
        List<Integer> b = Arrays.asList(5, 4, 6, 14, 19);
        int k = 2;
        System.out.println(minimumDivision(a, b, k)); // Output: 2
    }
}
