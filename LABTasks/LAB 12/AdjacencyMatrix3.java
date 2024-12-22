import java.util.ArrayList;
public class AdjacencyMatrix3 {

    private int[][]matrix;
    private ArrayList<Vertexz> v = new ArrayList<>();
    private int size;
     static class Vertexz{
        private char data;

        public Vertexz(char data){
            this.data = data;
        }
        public char getData(){
            return data;
        }
    }

    public AdjacencyMatrix3(int size){
        this.size = size;
        matrix = new int[size][size];
    }
    public void addEdge(int source, int destination){
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }
    public void addVertex(Vertexz vertex){
        v.add(vertex);
    }

    public void removeEdge(int source, int destination){
        matrix[source][destination] = 0;
        matrix[destination][source] = 0;
    }
    public int totalSize(){
        return size*size;
    }
    public void printGraph(){
        System.out.print("  ");
        for(int i = 0; i < v.size(); i++){
            System.out.print(v.get(i).getData()+ " ");
        }
       System.out.println();
        for(int i = 0; i < matrix.length; i++){
            System.out.print(v.get(i).getData() + " ");
            for(int j = 0; j < matrix[i].length;j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
