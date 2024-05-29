package prb210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        // No prerequisites, can take in any order
        if(prerequisites==null) {
            int[] order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = i;
            }
            return order;
        }

        // Perform topological sort
        // Build adjecancy list
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Initialise adjacency list
        for(int i=0; i<numCourses; i++) {
            adjList.add( new ArrayList<>() );
        }

        // Build list and calculate indegree
        for(int[] prerequisite : prerequisites) {
            int course = prerequisite[1];
            int prereq = prerequisite[0];
            adjList.get( prereq ).add( course );
            indegree[course]++;
        }

        // BFS call
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer( i );
            }
        }

        // Perform processing of neighbors
        List<Integer> order = new ArrayList<>();
        while(!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);
            // Traverse neighbors and reduce indegree
            for(int neighbor : adjList.get(course)) {
                indegree[neighbor] --;
                if(indegree[neighbor]==0) {
                    // Add to order
                    queue.offer(neighbor);
                }
            }
        }

        // Answer condition, return empty list if no order possible
        if(order.size()!=numCourses){
            return new int[0];
        }

        // Else convert to a list of order
        int[] result = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }

    public static void main( String[] args ) {
        // [[1,0],[2,0],[3,1],[3,2]]
        int[][] courseList = {{1,0},{2,0},{3,1},{3,2}};
        int numCourses = 4;
        Solution sol = new Solution();
        int[] solution = sol.findOrder( numCourses, courseList );
    }
}
