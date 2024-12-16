import java.util.ArrayList;

public class AdjacencyMatrix2{
    static class Vertex {
        char data;

        public Vertex(char data) {
            this.data = data;
        }
    }

    private ArrayList<Vertex> vertices = new ArrayList<>();
    private int[][] matrix;
    private int size;

    AdjacencyMatrix2(int size) {
        this.size = size;
        matrix = new int[size][size];
    }

    public void addVertex(char data) {
        vertices.add(new Vertex(data));
    }

    public void addEdge(char source, char destination) {
        int sourceIndex = getIndex(source);
        int destinationIndex = getIndex(destination);
        if (sourceIndex == -1 || destinationIndex == -1) {
            System.out.println("Invalid Edge");
        } else {
            matrix[sourceIndex][destinationIndex] = 1;
            matrix[destinationIndex][sourceIndex] = 1;
        }
    }

    public void removeEdge(char source, char destination) {
        int sourceIndex = getIndex(source);
        int destinationIndex = getIndex(destination);
        if (sourceIndex == -1 || destinationIndex == -1) {
            System.out.println("Invalid Edge");
        } else {
            matrix[sourceIndex][destinationIndex] = 0;
            matrix[destinationIndex][sourceIndex] = 0;
        }
    }

    public boolean isEdge(char source, char destination) {
        int sourceIndex = getIndex(source);
        int destinationIndex = getIndex(destination);
        if (sourceIndex == -1 || destinationIndex == -1) {
            System.out.println("Invalid Edge");
            return false;
        } else {
            return matrix[sourceIndex][destinationIndex] == 1;
        }
    }

    private int getIndex(char data) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).data == data) {
                return i;
            }
        }
        return -1;
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertices.get(i).data + " : ");
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix2 graph = new AdjacencyMatrix2(5);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('A', 'E');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('D', 'E');

        graph.printMatrix();
        System.out.println();
        // System.out.println(graph.isEdge('C', 'D'));
        // graph.removeEdge('C', 'D');
        graph.printMatrix();
    }
}
