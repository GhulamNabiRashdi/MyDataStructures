import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree<T extends Comparable<T>> {
    private class Node {
        private T data;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (!isEmpty()) {

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node temp = queue.remove();
                // System.out.println(temp.data);

                if (temp.left == null) {
                    temp.left = newNode;
                    // System.out.println("Node inserted Successfully left side");
                    return;
                } else if (temp.right == null) {
                    temp.right = newNode;
                    // System.out.println("Node inserted Sucessfully Right Side");
                    return;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);

                }

            }
        } else {
            root = newNode;
            // System.out.println("Node Inserted as root");
            return;
        }

    }

    public void levelOrderTraversal() {
        if (!isEmpty()) {
            System.out.println("\"Level Order Traversal\"");
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node temp = queue.remove();
                System.out.print(temp.data + " ");

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            System.out.println();
        } else {
            System.out.println("tree is Empty unable to traverse");
        }
    }

    public void inOrder() {
        if (!isEmpty()) {
            System.out.println("\"In Order Traversal\"");
            inOrder(root);
            System.out.println();
        } else {
            System.out.println("no Elements Found");
        }
    }

    private void inOrder(Node root) {
        if (root == null) {
            // System.out.println();
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder() {
        if (!isEmpty()) {
            System.out.println("\"Pre Order Traversal\"");
            preOrder(root);
            System.out.println();
        } else {
            System.out.println("no Elements Found");
        }
    }

    private void preOrder(Node root) {
        if (root == null) {
            // System.out.println();
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        if (!isEmpty()) {
            System.out.println("\"Post Order Traversal\"");
            postOrder(root);
            System.out.println();
        } else {
            System.out.println("no Elements Found");
        }
    }

    private void postOrder(Node root) {
        if (root == null) {
            // System.out.println();
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    public int levelofBinaryTree() {
        if (isEmpty()) {
            System.out.println("Tree is Empty");
            return -1;
        } else {
            int depth = 0;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {

                depth++;

                for (int i = 0; i < queue.size(); i++) {
                    Node temp = queue.remove();
                    if (temp.left != null) {
                        queue.add(temp.left);

                    }
                    if (temp.right != null) {
                        queue.add(temp.right);

                    }
                }

            }
            depth--;
            System.out.println("There are " + depth + " levels in this binary tree");
            return depth;

        }

    }

    public int totalNumberOfNodes() {
        int nodes = 0;
        nodes = totalNumberOfNodes(root);
        System.out.println("Total Number of Nodes in this binary tree are: " + nodes);
        return nodes;
    }

    private int totalNumberOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + totalNumberOfNodes(root.left) + totalNumberOfNodes(root.right);

    }

    public boolean isBalanced() {
        if (root == null) {
            System.out.println("Tree is Empty");
            return true;
        }
        int left = 0;
        int right = 0;
        left = isBalanced(root.left);
        right = isBalanced(root.right);

        System.out.println("Depth of Left: " + left);
        System.out.println("Depth of Right: " + right);

        int ret = Math.abs(left - right);
        System.out.println("Ratio of Balance between Left and Right Depth is: " + ret);
    
        if (ret <= 1)
            return true;

        return false;
    }

    private int isBalanced(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(isBalanced(root.left), isBalanced(root.right)) + 1;
    }

    public int depthOfBinaryTree() {
        if (!isEmpty()) {
            int level = levelofBinaryTree();
            level = level + 1;
            System.out.println("Depth of This Binary Tree is : " + level);
            return level;
        } else {
            System.out.println("Tree is Empty");
            return -1;
        }

    }
    public boolean isSubTree(Node T, Node S) {
        if (S == null) {
            return true;
        }
        if (T == null) {
            return false;
        }
        if (isIdentical(T, S)) {
            return true;
        }
        return isSubTree(T.left, S) || isSubTree(T.right, S);
    }

    private boolean isIdentical(Node T, Node S) {
        if (T == null && S == null) {
            return true;
        }
        if (T == null || S == null) {
            return false;
        }
        return T.data.equals(S.data) && isIdentical(T.left, S.left) && isIdentical(T.right, S.right);
    }

    public static void main(String[] args) {
        // System.out.println("hello WOrld!");
        CompleteBinaryTree<Integer> cTree = new CompleteBinaryTree<>();
        cTree.add(10);
        cTree.add(20);
        cTree.add(30);
        cTree.add(40);
        cTree.add(50);
        cTree.add(60);
        cTree.add(70);
        cTree.add(80);
        cTree.add(90);
        cTree.add(100);
        cTree.add(110);
        cTree.add(120);
        cTree.add(130);
        cTree.add(140);
        cTree.add(150);
        cTree.add(160);
        cTree.add(170);
        cTree.add(180);
        cTree.add(190);
        cTree.add(210);
        cTree.add(220);
        cTree.add(230);
        cTree.add(240);
        cTree.add(250);
        cTree.add(260);
        cTree.add(270);
        cTree.add(280);
        cTree.add(290);
        cTree.add(300);
        cTree.levelOrderTraversal();
        cTree.inOrder();
        // System.out.println();
        cTree.preOrder();
        // System.out.println();
        cTree.postOrder();
        // System.out.println();
        cTree.levelofBinaryTree();
        cTree.depthOfBinaryTree();
        cTree.totalNumberOfNodes();
        
        System.out.println("Is Tree Balanced?: "+ cTree.isBalanced());
    }
}
