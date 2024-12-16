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

    private void insert(Node newNode, BinarySearchTree.Node root2) {
        if (newNode == null) {
            return;
        } else {
            if (newNode.data.compareTo((T) root2.data) < 0) {
                if (root2.left == null) {
                    root2.left = newNode;
                } else {
                    insert(newNode, root2.left);
                    // root2.left = newNode;
                }
            } else {
                if (root2.right == null) {
                    root2.right = newNode;
                } else {
                    insert(newNode, root2.right);
                    // root2.right = newNode;
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
        } else if (root.data.compareTo(data) == 0) {
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

    private void smallestElement(BinarySearchTree.Node root2) {
        if (root2.left == null) {
            System.out.println(root2.data);
            return;
        } else {
            smallestElement(root2.left);
        }
    }

    public void largestElement() {
        smallestElement(root);
    }

    private void largestElement(BinarySearchTree.Node root2) {
        if (root2.right == null) {
            System.out.println(root2.data);
            return;
        } else {
            smallestElement(root2.right);
        }
    }

    public void BFS() {
        BFS(root);
    }

    private void BFS(BinarySearchTree.Node root) {
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
