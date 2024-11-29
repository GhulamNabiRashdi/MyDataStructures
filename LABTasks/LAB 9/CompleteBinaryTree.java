public class CompleteBinaryTree <T extends Comparable>{
    private class Node{
        private T data;
        private Node left;
        private Node right;
        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    public void insert(T data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        }else{
            insert(newNode, root);
        }
    }
    private void insert(Node newNode, Node root){
        if(newNode.data.compareTo(root.data) < 0){
            if(root.left == null){
                root.left = newNode;
            }else{
                insert(newNode, root.left);
            }
        }else{
            if(root.right == null){
                root.right = newNode;
            }else{
                insert(newNode, root.right);
            }
        }
    }
}
