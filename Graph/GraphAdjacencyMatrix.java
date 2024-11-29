package Graph;

public class GraphAdjacencyMatrix {
    int[][] AdjacencyMatrix;
    int vertices;

    public GraphAdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        AdjacencyMatrix = new int[vertices][vertices];
    }
    public void addEdge(int source, int destination){
        AdjacencyMatrix[source][destination] = 1;
        AdjacencyMatrix[destination][source] = 1;
    }
    public void printGraph(){
        for(int i = 0; i < vertices; i++){
            System.out.print("Vertex " + i + " is connected to: ");
            for(int j = 0; j < vertices; j++){
                if(AdjacencyMatrix[i][j] == 1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
    }

}
class Node{
    char data;
    
    public Node(char data){
        this.data = data;
    }
}
