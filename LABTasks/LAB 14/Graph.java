import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {

    static class Pair implements Comparable<Pair> {

        private int node;
        private int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Pair node) {
            return this.weight - node.weight;
        }
    }

    private int numOfVertices;
    private ArrayList<Pair> graph[];

    @SuppressWarnings("unchecked")

    public Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        graph = new ArrayList[numOfVertices];
        initializer(graph);
    }

    private void initializer(ArrayList<Pair> graph[]) {
        for (int i = 0; i < numOfVertices; i++) {
            graph[i] = new ArrayList<>(numOfVertices);
        }
    }

    public void addUndirectedEdge(int source, int destination, int weight) {
        Pair pair1 = new Pair(destination, weight);
        graph[source].add(pair1);

        Pair pair2 = new Pair(source, weight);
        graph[destination].add(pair2);
    }

    public void getAllNeighbours() {
        for (int i = 0; i < numOfVertices; i++) {
            System.out.print("Node: " + i + " => ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print("[" + graph[i].get(j).node + " " + graph[i].get(j).weight + "] ");
            }
            System.out.println();
        }
    }

    public int[] dijkstra(int startNode) {
        int[] distances = new int[numOfVertices];
        boolean[] visited = new boolean[numOfVertices];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < numOfVertices; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distances[startNode] = 0;
        pq.add(new Pair(startNode, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();
            int currentNode = current.node;

            if (visited[currentNode])
                continue;
            visited[currentNode] = true;

            // for (Pair neighbor : graph[currentNode]) {
            // int newDist = distances[currentNode] + neighbor.weight;
            // if (newDist < distances[neighbor.node]) {
            // distances[neighbor.node] = newDist;
            // pq.add(new Pair(neighbor.node, newDist));
            // }
            // }
            for (int i = 0; i < graph[currentNode].size(); i++) {
                Pair neighbor = graph[currentNode].get(i);
                int newDist = distances[currentNode] + neighbor.weight;
                if (newDist < distances[neighbor.node]) {
                    distances[neighbor.node] = newDist;
                    pq.add(new Pair(neighbor.node, newDist));
                }
            }
        }
        return distances;
    }

    public int[] primsAlgorithm(int startNode) {
        int[] parent = new int[numOfVertices];
        int[] distances = new int[numOfVertices];
        boolean[] isVisited = new boolean[numOfVertices];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < numOfVertices; i++) {
            distances[i] = Integer.MAX_VALUE;
            isVisited[i] = false;
            parent[i] = -1;
        }
        distances[startNode] = 0;
        pq.add(new Pair(startNode, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentNode = current.node;

            if (isVisited[currentNode])
                continue;
            isVisited[currentNode] = true;

            for (int i = 0; i < graph[currentNode].size(); i++) {
                Pair neighbor = graph[currentNode].get(i);
                
                if (!isVisited[neighbor.node] && neighbor.weight < distances[neighbor.node]) {
                    distances[neighbor.node] = neighbor.weight;
                    pq.add(new Pair(neighbor.node, distances[neighbor.node]));
                    parent[neighbor.node] = currentNode;
                }
            }
            // for (Pair neighbor : graph[currentNode]) {
            // if (!isVisited[neighbor.node] && neighbor.weight < distances[neighbor.node]) {
            // distances[neighbor.node] = neighbor.weight;
            // pq.add(new Pair(neighbor.node, distances[neighbor.node]));
            // parent[neighbor.node] = currentNode;
            // }
            // }

        }
        return parent;
    }

}
