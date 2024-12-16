package Graph;

import java.util.ArrayList;

public class GraphArrayofArrList {
    ArrayList<Pair> graph[];
    private int size;

    public static class Pair implements Comparable<Pair>{

        public int node;
        public int weight;

        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair node) {

            return this.weight - node.weight;


           
        }
    }
    public GraphArrayofArrList(int size){
        graph = new ArrayList[size];
        initialize(graph,size);
            }
            
            @SuppressWarnings("unchecked")
            private void initialize(ArrayList<Pair>[] graph, int size) {
               for(int i = 0; i < size; i++){
                graph = new ArrayList[size];
               }
            }
        
            public void addEdge(){

    }
    
}
