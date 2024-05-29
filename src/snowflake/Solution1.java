package snowflake;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static int calculateMax(int networkNodes, List<Integer> networkFrom, List<Integer> networkTo, List<Integer> frequency) {
        // Construct the adjacency list representing the tree
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= networkNodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < networkFrom.size(); i++) {
            int from = networkFrom.get(i);
            int to = networkTo.get(i);
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        // Initialize variables
        int[] freq = new int[frequency.size()];
        for (int i = 0; i < frequency.size(); i++) {
            freq[i] = frequency.get(i);
        }
        int maxDistance = 0;

        // Start DFS from any node
        for (int i = 1; i <= networkNodes; i++) {
            maxDistance = Math.max(maxDistance, dfs(i, -1, 0, adjList, freq));
        }

        return maxDistance;
    }

    private static int dfs(int node, int parent, int distance, List<List<Integer>> adjList, int[] frequency) {
        int maxDist = 0;
        for (int neighbor : adjList.get(node)) {
            if (neighbor != parent) {
                if (Math.abs(frequency[node - 1] - frequency[neighbor - 1]) <= 1) {
                    maxDist = Math.max(maxDist, dfs(neighbor, node, distance + 1, adjList, frequency));
                } else {
                    //
                    maxDist = Math.max(maxDist, dfs(neighbor, node, 0, adjList, frequency));
                }
            }
        }
        return maxDist + distance;
    }

    public static void main(String[] args) {
        int network_nodes = 5;
        List<Integer> network_from = List.of(1, 1, 2, 2);
        List<Integer> network_to = List.of(2, 3, 4, 5);
        List<Integer> frequency = List.of(1, 2, 3, 2, 1);

        int longestDist = calculateMax(network_nodes, network_from, network_to, frequency);
        System.out.println("Longest distance between devices: " + longestDist);
    }
}
