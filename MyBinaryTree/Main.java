public class Main{
    public static void main(String[]args){
        BinaryTree<Integer> bT = new BinaryTree<>();
        System.out.println("Hello WOrlD!");
        bT.insert(10);
        bT.insert(11);
        bT.insert(12);
        bT.insert(13);
        bT.insert(14);
        bT.insert(15);
        bT.insert(16);
        bT.insert(17);
        bT.insert(9);
        bT.insert(8);
        bT.insert(7);
        bT.insert(6);
        bT.insert(5);
        bT.insert(4);
        bT.insert(3);
        bT.insert(2);
        bT.insert(1);
        bT.insert(11);
        bT.insert(12);
        bT.insert(13);
        bT.insert(14);
        bT.insert(15);
        bT.insert(16);
        bT.insert(17);
        System.out.println("Post Order Traverse");
        bT.postOrderTraverse();
        System.out.println("Pre Order Treverse");
        bT.preOrderTraverse();
        System.out.println("\nIn Order Treverse");
        bT.inOrderTraverse();
        System.out.println();
        System.out.println(bT.contains(17));
    
    }
}