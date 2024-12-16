import java.util.ArrayList;

public class AdjacencyList {
    class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    private ArrayList<ArrayList<Edge>> adjacencyList;
    private int size;

    public AdjacencyList(int size) {
        adjacencyList = new ArrayList<>(size);
        initializer(adjacencyList);
    }

    private void initializer(ArrayList<ArrayList<Edge>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            adjacencyList.add(new ArrayList<>());
        }

    }

    public void addEdge(int source, AdjacencyList.Edge destination) {
        adjacencyList.get(source).add(destination);
    }
}
