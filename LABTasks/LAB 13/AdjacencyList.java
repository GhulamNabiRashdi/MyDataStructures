// import java.util.ArrayList;

// public class AdjacencyList {
//     class Edge {
//         int source;
//         int destination;

//         public Edge(int source, int destination) {
//             this.source = source;
//             this.destination = destination;
//         }
//     }

//     private ArrayList<ArrayList<Integer>> adjacencyList;
//     private int size;

//     public AdjacencyList(int size) {
//         this.size = size;
//         adjacencyList = new ArrayList<>(size);
//         initializer(adjacencyList);
//     }

//     private void initializer(ArrayList<ArrayList<Integer>> adjacencyList) {
//         for (int i = 0; i <size; i++) {
//             adjacencyList.add(new ArrayList<>());
//         }

//     }

//     public void addEdge(int source, int destination) {
//         Edge edge = new Edge(source, destination);
//         adjacencyList.get(source).add(destination);
//         adjacencyList.get(destination).add(source);
//     }
//     public void printGraph(){
//         for(int i = 0; i < size; i ++){
//             System.out.print("Neighbours of " + i + " are: ");
//             for(int j = 0; j < adjacencyList.get(i).size(); j++){
//                 System.out.print(adjacencyList.get(i).get(j) + " ");

//             }
//             System.out.println();
//         }
//     }
// }
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyList {
    class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }

        @Override
        public String toString() {
            return source + " -> " + destination;
        }
    }

    private ArrayList<ArrayList<Edge>> adjacencyList;
    private int size;

    public AdjacencyList(int size) {
        this.size = size;
        adjacencyList = new ArrayList<>(size);
        initialize(adjacencyList);
    }

    private void initialize(ArrayList<ArrayList<Edge>> adjacencyList) {
        for (int i = 0; i < size; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addUndirectedEdge(int source, int destination) {
        Edge edge = new Edge(source, destination);
        adjacencyList.get(source).add(edge);

        // Adding reverse edge for undirected graph
        Edge reverseEdge = new Edge(destination, source);
        adjacencyList.get(destination).add(reverseEdge);
    }
    public void addDirectedEdge(int source, int destination) {
        Edge edge = new Edge(source, destination);
        adjacencyList.get(source).add(edge);       
    }

    public void printGraph() {
        for (int i = 0; i < size; i++) {
            System.out.print("Neighbours of " + i + " are: ");
            for (Edge edge : adjacencyList.get(i)) {
                System.out.print(edge.destination + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int startVertex) {
        if (startVertex < 0 || startVertex >= size) {
            System.out.println("Invalid Starting Vertex");
            return;
        }
        System.out.println("Breadth First Traversal");
        Queue<Integer> myQueue = new LinkedList<>();
        boolean[] isVisited = new boolean[size];
        myQueue.add(startVertex);
        isVisited[startVertex] = true;
        while (!myQueue.isEmpty()) {
            int currentVertex = myQueue.poll();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < adjacencyList.get(currentVertex).size(); i++) {
                Edge edge = adjacencyList.get(currentVertex).get(i);
                if (!isVisited[edge.destination]) {
                    myQueue.add(edge.destination);
                    isVisited[edge.destination] = true;
                }
            }
        }
        System.out.println();
    }

    public void DFS(int starVertex) {
        if (starVertex < 0 || starVertex >= size) {
            System.out.println("Invalid Starting point ");
            return;
        }
        boolean[] isVisited = new boolean[size];
        System.out.println("Depth First Traversal");
        DFS(starVertex, isVisited);
        System.out.println();
    }

    private void DFS(int startVertex, boolean[] isVisited) {
        isVisited[startVertex] = true;
        System.out.print(startVertex + " ");
        for (int i = 0; i < adjacencyList.get(startVertex).size(); i++) {
            Edge neighbours = adjacencyList.get(startVertex).get(i);
            if (!isVisited[neighbours.destination]) {
                DFS(neighbours.destination, isVisited);
            }
        }
    }
}
