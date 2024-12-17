public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addUndirectedEdge(0, 1, 3);
        graph.addUndirectedEdge(0, 2, 2);
        graph.addUndirectedEdge(1, 3, 4);
        graph.addUndirectedEdge(2, 4, 1);
        graph.addUndirectedEdge(3, 4, 5);
        graph.addUndirectedEdge(0, 4, 6);
        graph.addUndirectedEdge(1, 2, 7);

        graph.getAllNeighbours();
    }
}