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

    public static void dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];

        // Initialize distances and visited arrays
        for (int i = 0; i < n; i++) {
            distances[i] = INF;
            visited[i] = false;
        }

        distances[start] = 0; // Distance to start node is 0

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nodeId = node.id;

            if (visited[nodeId]) {
                continue;
            }

            visited[nodeId] = true;

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[nodeId][neighbor] > 0 && !visited[neighbor]) {
                    int newDistance = distances[nodeId] + graph[nodeId][neighbor];

                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        pq.offer(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // Print the shortest distances
        for (int i = 0; i < n; i++) {
            System.out.println("Shortest distance from " + start + " to " + i + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
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

        dijkstra(graph, 0);
    }
}