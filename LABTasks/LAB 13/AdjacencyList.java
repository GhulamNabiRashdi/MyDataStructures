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
        this.size = size;
        adjacencyList = new ArrayList<>(size);
        initializer(adjacencyList);
    }

    private void initializer(ArrayList<ArrayList<Edge>> adjacencyList) {
        for (int i = 0; i <size; i++) {
            adjacencyList.add(new ArrayList<>());
        }

    }

    public void addEdge(int source, int destination) {
        Edge edge = new Edge(source, destination);
        adjacencyList.get(source).add(edge);
        adjacencyList.get(destination).add(edge);
    }
    public void printGraph(){
        for(int i = 0; i < size; i ++){
            System.out.print("Neighbours of " + i + " are: ");
            for(int j = 0; j < adjacencyList.get(i).size(); j++){
                System.out.print(adjacencyList.get(i).get(j).destination + " ");
            
            }
            System.out.println();
        }
    }
}
