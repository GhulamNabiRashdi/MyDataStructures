import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Arrays;
import java.util.Comparator;

public class Path2FinderGUI extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private JPanel panel;
    private JButton bfsButton, dfsButton, aStarButton, dijkstraButton, compareButton;
    private Graph graph;

    public Path2FinderGUI() {
        setTitle("Path Finder");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 5));

        bfsButton = new JButton("BFS");
        dfsButton = new JButton("DFS");
        aStarButton = new JButton("A*");
        dijkstraButton = new JButton("Dijkstra");
        compareButton = new JButton("Compare");

        panel.add(bfsButton);
        panel.add(dfsButton);
        panel.add(aStarButton);
        panel.add(dijkstraButton);
        panel.add(compareButton);

        add(panel, BorderLayout.SOUTH);

        graph = new Graph();
        add(graph, BorderLayout.CENTER);

        // Adding ActionListeners using lambda expressions for conciseness
        bfsButton.addActionListener(e -> graph.bfs());
        dfsButton.addActionListener(e -> graph.dfs());
        aStarButton.addActionListener(e -> graph.aStar());
        dijkstraButton.addActionListener(e -> graph.dijkstra());

        compareButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter algorithm numbers (separated by commas) to compare:");
            if (input != null) {
                String[] selectedAlgorithms = input.split(",");
                for (String algorithm : selectedAlgorithms) {
                    try {
                        int algoNumber = Integer.parseInt(algorithm.trim());
                        graph.reset(); // Reset the graph state before running each algorithm
                        switch (algoNumber) {
                            case 1:
                                graph.bfs();
                                break;
                            case 2:
                                graph.dfs();
                                break;
                            case 3:
                                graph.aStar();
                                break;
                            case 4:
                                graph.dijkstra();
                                break;
                            default:
                                System.out.println("Invalid algorithm number");
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input format. Please enter numeric values.");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Path2FinderGUI().setVisible(true));
    }
}

class Graph extends JPanel {
    private static final int NODE_RADIUS = 20;
    private int[][] adjacencyMatrix;
    private int numVertices;
    private List<Integer> visitedNodes = new ArrayList<>();

    public Graph() {
        numVertices = 10; // Example number of vertices
        adjacencyMatrix = new int[numVertices][numVertices];
        // visitedNodes is already initialized in the constructor
        // Initialize the adjacency matrix with some random values
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {
                    adjacencyMatrix[i][j] = (int) (Math.random() * 10) + 1; // Random weights between 1 and 10
                }
            }
        }
    }

    public void bfs() {
        System.out.println("BFS Algorithm");
        visitedNodes.clear(); // Reset visited nodes
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        int startVertex = 0; // Example start vertex

        visited[startVertex] = true;
        queue.add(startVertex);
        visitedNodes.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[vertex][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    visitedNodes.add(i);
                }
            }
        }
        repaint();  // Repaint to show the visited nodes
    }

    public void dfs() {
        System.out.println("DFS Algorithm");
        visitedNodes.clear(); // Reset visited nodes
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();
        int startVertex = 0; // Example start vertex

        stack.push(startVertex);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                visited[vertex] = true;
                visitedNodes.add(vertex);
            }
            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[vertex][i] != 0 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
        repaint();  // Repaint to show the visited nodes
    }

    public void aStar() {
        System.out.println("A* Algorithm");
        visitedNodes.clear(); // Reset visited nodes
        int startVertex = 0;
        int goalVertex = numVertices - 1;

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(node -> node.f));
        Set<Integer> closedList = new HashSet<>();
        Node startNode = new Node(startVertex, 0, heuristic(startVertex, goalVertex));
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            int currentVertex = currentNode.vertex;

            if (currentVertex == goalVertex) {
                System.out.println("Path found to goal vertex " + goalVertex);
                break;
            }

            closedList.add(currentVertex);
            visitedNodes.add(currentVertex); // Mark the node as visited

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[currentVertex][i] != 0 && !closedList.contains(i)) {
                    int tentativeG = currentNode.g + adjacencyMatrix[currentVertex][i];
                    Node neighborNode = new Node(i, tentativeG, heuristic(i, goalVertex));

                    if (openList.stream().noneMatch(node -> node.vertex == i && node.g <= tentativeG)) {
                        openList.add(neighborNode);
                    }
                }
            }
        }
        repaint();  // Repaint to show the visited nodes
    }

    private int heuristic(int vertex, int goal) {
        return Math.abs(vertex - goal); // Example heuristic: Manhattan distance
    }

    private static class Node {
        int vertex;
        int g; // Cost from start to this node
        int f; // Estimated cost from start to goal through this node

        Node(int vertex, int g, int h) {
            this.vertex = vertex;
            this.g = g;
            this.f = g + h;
        }
    }

    public void dijkstra() {
        System.out.println("Dijkstra Algorithm");
        visitedNodes.clear(); // Reset visited nodes
        int startVertex = 0;
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.g));

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;
        priorityQueue.add(new Node(startVertex, 0, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            int currentVertex = currentNode.vertex;

            if (visited[currentVertex]) {
                continue;
            }

            visited[currentVertex] = true;
            visitedNodes.add(currentVertex); // Mark the node as visited

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[currentVertex][i] != 0 && !visited[i]) {
                    int newDist = distances[currentVertex] + adjacencyMatrix[currentVertex][i];
                    if (newDist < distances[i]) {
                        distances[i] = newDist;
                        priorityQueue.add(new Node(i, newDist, 0));
                    }
                }
            }
        }
        repaint();  // Repaint to show the visited nodes
    }

    public void reset() {
        visitedNodes.clear();
        // Additional reset logic if needed
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int angleStep = 360 / numVertices;

        Point[] positions = new Point[numVertices];
        for (int i = 0; i < numVertices; i++) {
            int angle = i * angleStep;
            int x = (int) (centerX + 200 * Math.cos(Math.toRadians(angle)));
            int y = (int) (centerY + 200 * Math.sin(Math.toRadians(angle)));
            positions[i] = new Point(x, y);
        }

        // Draw edges
        g.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    g.drawLine(positions[i].x, positions[i].y, positions[j].x, positions[j].y);
                }
            }
        }

                
            
        

        // Draw nodes
        for (int i = 0; i < numVertices; i++) {
            if (visitedNodes.contains(i)) {
                g.setColor(Color.GREEN); // Visited nodes
            } else {
                g.setColor(Color.RED); // Non-visited nodes
            }
            g.fillOval(positions[i].x - NODE_RADIUS / 2, positions[i].y - NODE_RADIUS / 2, NODE_RADIUS, NODE_RADIUS);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(i), positions[i].x, positions[i].y);
        }
    }
}

