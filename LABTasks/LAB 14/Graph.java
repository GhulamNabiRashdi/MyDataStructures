import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph{

    static class Pair implements Comparable<Pair>{
        private int node;
        private int weight;

        public Pair(int node,int weight){
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

    public Graph(int numOfVertices){
        this.numOfVertices = numOfVertices;
        graph = new ArrayList[numOfVertices];
        initializer(graph);
    }
    private void initializer(ArrayList<Pair> graph[]){
        for(int i = 0; i < numOfVertices; i++){
            graph[i] = new ArrayList<>(numOfVertices);
        }
    }
    public void addUndirectedEdge(int source, int destination, int weight){
        Pair pair1 = new Pair(destination, weight);
        graph[source].add(pair1);
        
        Pair pair2 = new Pair(source, weight);
        graph[destination].add(pair2);
    }
    public void getAllNeighbours(){
        for(int i = 0; i < numOfVertices; i++){
            System.out.print("Node: "+i+" => ");
            for(int j = 0; j < graph[i].size(); j++){
                System.out.print("["+graph[i].get(j).node+" "+graph[i].get(j).weight+"] ");
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

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            for (Pair neighbor : graph[currentNode]) {
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
            int[] key = new int[numOfVertices];
            boolean[] inMST = new boolean[numOfVertices];
            PriorityQueue<Pair> pq = new PriorityQueue<>();

            for (int i = 0; i < numOfVertices; i++) {
                key[i] = Integer.MAX_VALUE;
                inMST[i] = false;
                parent[i] = -1;
            }
            key[startNode] = 0;
            pq.add(new Pair(startNode, 0));

            while (!pq.isEmpty()) {
                Pair current = pq.poll();
                int currentNode = current.node;

                if (inMST[currentNode]) continue;
                inMST[currentNode] = true;

                for (Pair neighbor : graph[currentNode]) {
                    if (!inMST[neighbor.node] && neighbor.weight < key[neighbor.node]) {
                        key[neighbor.node] = neighbor.weight;
                        pq.add(new Pair(neighbor.node, key[neighbor.node]));
                        parent[neighbor.node] = currentNode;
                    }
                }
            }
            return parent;
        }
    
    
}

