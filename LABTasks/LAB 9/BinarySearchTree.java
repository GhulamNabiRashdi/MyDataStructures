import java.util.*;
import java.util.LinkedList;
public class BinarySearchTree<T extends Comparable<T>> {

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

    public void insert(T data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            insert(newNode, root);
        }
    }

    private void insert(Node newNode, Node root) {
        if (newNode == null) {
            return;
        } else {
            if (newNode.data.compareTo((T) root.data) < 0) { //newNode.data < root.data
                if (root.left == null) {
                    root.left = newNode;
                } else {
                    insert(newNode, root.left);
                    // root.left = newNode;
                }
            } else {
                if (root.right == null) {
                    root.right = newNode;
                } else {
                    insert(newNode, root.right);
                    // root.right = newNode;
                }
            }
        }
    }

    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public boolean search(T data) {
        return search(data, root);
    }

    private boolean search(T data, Node root) {
        if (root == null) {
            return false;
        } else if (root.data.compareTo(data) == 0) { // root.data == data
            return true;
        } else if (root.data.compareTo(data) > 0) {
            return search(data, root.left);
        } else {
            return search(data, root.right);
        }
    }

    public void smallestElement() {
        smallestElement(root);
    }

    private void smallestElement(Node root) {
        if (root.left == null) {
            System.out.println(root.data);
            return;
        } else {
            smallestElement(root.left);
        }
    }

    public void largestElement() {
        smallestElement(root);
    }

    private void largestElement(Node root) {
        if (root.right == null) {
            System.out.println(root.data);
            return;
        } else {
            smallestElement(root.right);
        }
    }

    public void BFS() {
        BFS(root);
    }

    private void BFS(Node root) {
        if(root != null){
        Queue<Node> myQueue = new LinkedList<>();
        myQueue.offer(root);
        while(!myQueue.isEmpty()){
            Node temp = myQueue.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null){
                myQueue.offer(temp.left);
            }
            if(temp.right != null){
                myQueue.offer(temp.right);
            }    
        }
        
        
    }
    }
    public int countofNodes(){
        int i = 0;
        Queue<Node> myQueue = new LinkedList<>();
        myQueue.offer(root);
        while(!myQueue.isEmpty()){
            Node temp = myQueue.poll();
            i++;
            if(temp.left != null){
                myQueue.offer(temp.left);
            }
            if(temp.right != null){
                myQueue.offer(temp.right);
            }    
        }

        return i;
    }
    public int height(){
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    } 

}   
