public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    Node head;
    public static void removeNodes(Node head, int M, int N){
        if(head == null){
            return;
        }
        else{
            int count = 0;
            Node temp = head;

            while(temp.next != null){
                if(count < M -1){
                    temp = temp.next;
                    count++;
                }
                else{
                    break;
                }
            }
            count = 0;
            while(temp.next != null){
                if(count < N){
                    temp.next = temp.next.next;
                    count++;
                }
                else{
                    break;
                }
            }
        
            printLinkedList(head);

        }
        
        
    }
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            
            
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            
        }
    }

    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("Link is Empty");
            return;
        } else {
            Node temp = head;
            while (temp.next != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;

            }
            System.out.println(temp.data);
        }
    }

    public static void main(String[] args) {
        
         Node node1 = new Node(9);
         Node node2 = new Node(1);
         Node node3 = new Node(3);
         Node node4 = new Node(5);
         Node node5 = new Node(9);
         Node node6 = new Node(4);
         Node node7 = new Node(10);
         Node node8 = new Node(1);
         node1.next = node2;
         node2.next = node3;
         node3.next = node4;
         node4.next = node5;
         node5.next = node6;
         node6.next = node7;
         node7.next = node8;
         node8.next = null;
        //  node.addLast(1);
        //  node.addLast(3);
        //  node.addLast(5);
        //  node.addLast(9);
        //  node.addLast(4);
        //  node.addLast(10);
        //  node.addLast(1);
        // // node.next.data = 1;
        // node.next.next.data = 3;
        // node.next.next.next.data = 5;
        // node.next.next.next.next.data = 9;
        // node.next.next.next.next.next.data = 4;
        // node.next.next.next.next.next.next.data = 10;
        // node.next.next.next.next.next.next.next.data = 1;
        
         //removeNodes(node, 2, 3);
         printLinkedList(node1);
         removeNodes(node1, 2, 3);
        
    }
}