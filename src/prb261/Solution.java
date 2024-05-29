package prb261;

import java.util.*;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A valid tree has n-1 edges
        if(edges.length!=(n-1)){
            return false;
        }

        // Check for cycles
        // Convert to adjacency list
        HashMap<Integer, List<Integer> > adjList = new HashMap<>();
        adjList = createAdjList(edges);

        // Parent list
        Map<Integer, Integer> parent = new HashMap<>();
        // Visited nodes with parents
        parent.put( 0, -1 );
        // Create stack
        Stack<Integer> stack = new Stack<>();
        stack.push( 0 );

        // Iterate till stack not empty
        while(!stack.isEmpty()) {
            // pop one off
            int node = stack.pop();
            for(int neighbor : adjList.get( node )) {
                if(parent.get(node)==neighbor) {
                    // Trivial cycle
                    continue;
                }
                if(parent.containsKey( neighbor )) {
                    return false;
                }
                stack.push(neighbor);
                parent.put(neighbor, node);
            }

        }

        return parent.size() == n;

    }

    public HashMap<Integer, List<Integer> > createAdjList(int[][] edges) {
        HashMap<Integer, List<Integer> > adjList = new HashMap<>();
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Check if exists
            if(!adjList.containsKey( u )) {
                adjList.put( u, new ArrayList<>() );
            }
            if(!adjList.containsKey( v )) {
                adjList.put( v, new ArrayList<>() );
            }


            // Add values
            adjList.get(u).add( v );
            adjList.get(v).add( u );
        }
        return adjList;
    }
}