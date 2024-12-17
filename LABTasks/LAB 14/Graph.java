import java.util.ArrayList;

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
    

    
}