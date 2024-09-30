public class BinaryTree<T extends Comparable<T>> {
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

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            insertNode(root, newNode);
        }
    }

    private void insertNode(Node currentNode, Node newNode) {
        if (newNode == null) {
            return;
        }

        if (newNode.data.compareTo(currentNode.data) < 0) {
            if (currentNode.left == null) {
                currentNode.left = newNode;
            } else {
                insertNode(currentNode.left, newNode);
            }
        } else if (newNode.data.compareTo(currentNode.data) == 0) {
            currentNode.data = newNode.data;
        } else {
            if (currentNode.right == null) {
                currentNode.right = newNode;
            } else {
                insertNode(currentNode.right, newNode);
            }
        }
    }

    public void preOrderTraverse(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        } else {
            return;
        }
    }

    public void preOrderTraverse() {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        } else {

            return;
        }
    }

    public void inOrderTraverse(Node root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.data + " ");
            inOrderTraverse(root.right);
        } else {

            return;
        }
    }

    public void inOrderTraverse() {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.data + " ");
            inOrderTraverse(root.right);
        } else {
            return;
        }
    }

    public void postOrderTraverse(Node root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.data + " ");
        } else {

            return;
        }
    }

    public void postOrderTraverse() {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.println(root.data + " ");
        } else {

            return;
        }
    }

    public boolean contains(T Element) {
        return contains(root, Element);
    }

    private boolean contains(Node root, T element) {
        if (root == null) {
            return false;
        }
        int compare = root.data.compareTo(element);
        if (compare > 0) {
            return contains(root.left, element);
        } else if (compare < 0) {
            return contains(root.right, element);
        } else {
            return true;
        }

    }

}
