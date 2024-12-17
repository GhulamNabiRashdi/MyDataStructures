public class Main {
    // public static void main(String[] args) {
    //     AdjacencyList list = new AdjacencyList(5);
    //     list.addEdge(0, 1);
    //     list.addEdge(0, 3);
    //     list.addEdge(0, 4);
    //     list.addEdge(1, 2);
    //     list.addEdge(3, 2);
    //     list.addEdge(4, 3);

    //     list.printGraph();
    // }
    public static void main(String[] args) { AdjacencyList graph = new AdjacencyList(5); graph.addEdge(0, 1); graph.addEdge(0, 4); graph.addEdge(1, 2); graph.addEdge(1, 3); graph.addEdge(1, 4); graph.addEdge(2, 3); graph.addEdge(3, 4); graph.printGraph(); }
}
