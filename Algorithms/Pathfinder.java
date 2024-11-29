public class Pathfinder {
    // ...

    public void findPath(int startX, int startY, int endX, int endY) {
        // Implement A\* algorithm here
        // ...

        // Example implementation:
        Node startNode = grid[startX][startY];
        Node endNode = grid[endX][endY];

        startNode.setStart(true);
        endNode.setEnd(true);

        // Open list
        PriorityQueue<Node> openList = new PriorityQueue<>();
        openList.add(startNode);

        // Closed list
        boolean[][] closedList = new boolean[grid.length][grid[0].length];

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();

            if (currentNode == endNode) {
                // Reconstruct the path
                Node tempNode = currentNode;
                while (tempNode != startNode) {
                    tempNode.setPath(true);
                    tempNode = tempNode.getParent();
                }
                return;
            }

            closedList[currentNode.x][currentNode.y] = true;

            // Get neighbors
            Node[] neighbors = getNeighbors(currentNode);

            for (Node neighbor : neighbors) {
                if (neighbor != null && !closedList[neighbor.x][neighbor.y]) {
                    // Calculate the cost
                    int cost = currentNode.g + 1;

                    // Check if the neighbor is already in the open list
                    if (openList.contains(neighbor)) {
                        if (cost < neighbor.g) {
                            neighbor.g = cost;
                            neighbor.setParent(currentNode);
                        }
                    } else {
                        neighbor.g = cost;
                        neighbor.setParent(currentNode);
                        openList.add(neighbor);
                    }
                }
            }
        }
    }

    private Node[] getNeighbors(Node node) {
        Node[] neighbors = new Node[4];

        // Up
        if (node.y > 0) {
            neighbors[0] = grid[node.x][node.y - 1];
        }

        // Down
        if (node.y < grid[0].length - 1) {
            neighbors[1] = grid[node.x][node.y + 1];
        }

        // Left
        if (node.x > 0) {
            neighbors[2] = grid[node.x - 1][node.y];
        }

        // Right
        if (node.x < grid.length - 1) {
            neighbors[3] = grid[node.x + 1][node.y];
        }

        return neighbors;
    }
}