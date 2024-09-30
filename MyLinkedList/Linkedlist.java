public class Linkedlist {

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }


    public int removeFront() {
        if (head == null) {
            return -1; 
        }
        if (head.next == null) {
            int data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        } else {
            int data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    
    public int removeLast() {
        if (head == null) {
            return -1; 
        } else if (head.next == null) {
            int data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            int data = temp.next.data;
            temp.next = null;
            tail = temp;
            size--;
            return data;
        }
    }

    
    public void printLinkedList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();

        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.addLast(40);

        list.printLinkedList();

        System.out.println("Removed from front: " + list.removeFront());
        System.out.println("Removed from last: " + list.removeLast());

        list.printLinkedList();
    }
}