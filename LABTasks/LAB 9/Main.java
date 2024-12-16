

public class Main {
    public static void main(String[]args){
        System.out.println("hello World!");
       // BinarySearchTree<Integer> tree = new BinarySearchTree<>();
       CompleteBinaryTree<Integer> Ctree = new CompleteBinaryTree<>();

        tree.insert(10); //Root

        tree.insert(15); 
        tree.insert(5); 
        tree.insert(2); 
        tree.insert(7);
        tree.insert(20);
        tree.insert(25);
        tree.insert(8);

        // tree.preOrderTraversal();
        // System.out.println();
        // tree.postOrderTraversal();
        // System.out.println();
        // tree.inOrderTraversal();
        // System.out.println();
        // tree.smallestElement();
        tree.BFS();
    }

}
