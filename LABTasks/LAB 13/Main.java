public class Main {
    public static void main(String[] args) {
        AdjacencyList list = new AdjacencyList(5);
        // list.addUndirectedEdge(0, 1);
        // list.addUndirectedEdge(0, 3);
        // list.addUndirectedEdge(0, 4);
        // list.addUndirectedEdge(1, 2);
        // list.addUndirectedEdge(3, 2);
        // list.addUndirectedEdge(4, 3);
        // list.BFS(0);
        // list.DFS(0);
        // list.printGraph();
        list.addDirectedEdge(0, 1);
        list.addDirectedEdge(0, 2);
        list.addDirectedEdge(0, 3);
        list.addDirectedEdge(1, 3);
       // list.addDirectedEdge(0, 3);
        list.addDirectedEdge(2, 0);
        list.addDirectedEdge(2, 1);
        list.BFS(0);
        list.DFS(0);
    }
}
// public static void main(String[] args) {
//     AdjacencyList graph = new AdjacencyList(5);
//     graph.addUndirectedEdge(0, 1);
//     graph.addUndirectedEdge(0, 4);
//     graph.addUndirectedEdge(1, 2);
//     graph.addUndirectedEdge(1, 3);
//     graph.addUndirectedEdge(1, 4);
//     graph.addUndirectedEdge(2, 3);
//     graph.addUndirectedEdge(3, 4);
//     graph.BFS(0);

//     graph.printGraph();
// }
