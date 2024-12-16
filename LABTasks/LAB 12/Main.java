public class Main {
    public static void main(String[] args) {
    
    AdjacencyMatrix3 graph = new AdjacencyMatrix3(6);
    AdjacencyMatrix3.Vertexz v1 = new AdjacencyMatrix3.Vertexz('A');
    AdjacencyMatrix3.Vertexz v2 = new AdjacencyMatrix3.Vertexz('B');
    AdjacencyMatrix3.Vertexz v3 = new AdjacencyMatrix3.Vertexz('C');
    AdjacencyMatrix3.Vertexz v4 = new AdjacencyMatrix3.Vertexz('D');
    AdjacencyMatrix3.Vertexz v5 = new AdjacencyMatrix3.Vertexz('E');
    AdjacencyMatrix3.Vertexz v6 = new AdjacencyMatrix3.Vertexz('F');

    graph.addVertex(v1);
    graph.addVertex(v2);
    graph.addVertex(v3);
    graph.addVertex(v4);
    graph.addVertex(v5);
    graph.addVertex(v6);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(2, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 4);
    graph.addEdge(3, 5);
    graph.addEdge(4, 5);
    graph.printGraph();
    
        
    }
}
