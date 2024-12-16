package Graph;
import java.util.ArrayList;
public class GraphAdjacencyList {
    private class Edge{
        private int source;
        private int dest;

        public Edge(int source, int dest){
            this.source = source;
            this.dest = dest;


        }
    }
    private int numOfVertices;
    private ArrayList<ArrayList<Edge>> adjacencyList;

    public GraphAdjacencyList(int numOfVertices){
        this.numOfVertices = numOfVertices;
        adjacencyList = new ArrayList<>(numOfVertices);
        initialize(adjacencyList);
    }
    private void initialize(ArrayList<ArrayList<Edge>> adjacencyList){
        for(int i = 0; i < numOfVertices; i++){
            adjacencyList.add(new ArrayList<>());
        }
    }
    public void addEdge(int source, int dest){
        Edge edge = new Edge(source, dest);
        adjacencyList.get(source).add(edge);
    
    }
    public void printAllNeighbours(){
        for(int i = 0; i < numOfVertices; i++){
            System.out.print("Vertex " + i + " is connected to: ");
            for(Edge edge : adjacencyList.get(i)){
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }
    }
}
