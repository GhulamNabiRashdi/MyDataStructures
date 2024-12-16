import java.util.ArrayList;

public class AdjacencyMatrix {
    static class vertex {
        char data;

        public vertex(char data) {
            this.data = data;
        }
    }
    private ArrayList<vertex> vertices = new ArrayList<>();
    private int[][] matrix;
    private int size;


    AdjacencyMatrix(int size) {
        this.size = size;
        matrix = new int[size][size];
    }
    public void addVertex(char data) {
        vertices.add(new vertex(data));
    }
    public void addEdge(char source, char destination) {
        int sourceIndex = vertices.indexOf(source);
        int destinationIndex = vertices.indexOf(destination);
        if (sourceIndex >= size || destinationIndex >= size || sourceIndex < 0 || destinationIndex < 0) {
            System.out.println("Invalid Edge");
        } else {
            matrix[sourceIndex][destinationIndex] = 1;
            matrix[destinationIndex][sourceIndex] = 1;
        }

    }
    public void removeEdge(char source, char destination) {
        int sourceIndex = vertices.(source);
        int destinationIndex = vertices.indexOf(destination);
        if (sourceIndex >= size || destinationIndex >= size || sourceIndex < 0 || destinationIndex < 0) {
            System.out.println("Invalid Edge");
        } else {
            matrix[sourceIndex][destinationIndex] = 0;
            matrix[destinationIndex][sourceIndex] = 0;
        }
    }
    public boolean isEdge(char source, char destination) {
        if (source >= size || destination >= size || source < 0 || destination < 0) {
            System.out.println("Invalid Edge");
            return false;
        } else {
            return matrix[vertices.indexOf(source)][vertices.indexOf(destination)] == 1;
        }
    }
    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertices.get(i).data + "  ");
            for (int j = 0; j < size; j++) {
                
                
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(5);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge('A', 'B');
        // graph.addEdge('A', 'C');
        // graph.addEdge('A', 'D');
        // graph.addEdge('A', 'E');
        // graph.addEdge('B', 'C');
        // graph.addEdge('B', 'D');
        // graph.addEdge('B', 'E');
        // graph.addEdge('C', 'D');
        // graph.addEdge('C', 'E');
        // graph.addEdge('D', 'E');

      //  graph.printMatrix();
        
      //  System.out.println(graph.isEdge(3, 2));
       // graph.removeEdge(2, 3);
        graph.printMatrix();
    }
    

}
