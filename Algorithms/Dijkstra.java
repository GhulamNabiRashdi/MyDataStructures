import java.util.*;

class Node implements Comparable<Node> {
    int id;
    int distance;

    public Node(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}

public class Dijkstra {
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int startNode) {
        int numNodes = graph.length;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        // Initialize distances and visited arrays
        for (int i = 0; i < numNodes; i++) {
            distances[i] = INF;
            visited[i] = false;
        }

        // Distance to the start node is 0
        distances[startNode] = 0;

        // Create a priority queue to hold nodes to be processed
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startNode, 0));

        while (!queue.isEmpty()) {
            // Extract the node with the minimum distance from the queue
            Node currentNode = queue.poll();

            // If the node has already been visited, skip it
            if (visited[currentNode.id]) {
                continue;
            }

            // Mark the node as visited
            visited[currentNode.id] = true;

            // Update distances of neighboring nodes
            for (int i = 0; i < numNodes; i++) {
                if (graph[currentNode.id][i] > 0 && !visited[i]) {
                    int newDistance = distances[currentNode.id] + graph[currentNode.id][i];
                    if (newDistance < distances[i]) {
                        distances[i] = newDistance;
                        queue.add(new Node(i, newDistance));
                    }
                }
            }
        }

        // Print the shortest distances from the start node to all other nodes
        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Node " + i + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
        // Define a sample graph represented as an adjacency matrix
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        // Run Dijkstra's algorithm starting from node 0
        dijkstra(graph, 0);
    }
}