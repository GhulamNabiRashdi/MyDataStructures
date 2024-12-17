import java.util.Stack;

public class LinkedList {

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size = 0;

    
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
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
            size++;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
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
            size--;
            return data;
        } else {
            Node temp = head;
            Node prev = null;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            int data = temp.data;
            prev.next = null;
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
    public void printReverse(){
        if(head == null){
            return;
        }
        else{
            Stack<Integer> stack = new Stack<>();
            Node temp = head;
            while(temp != null){
                stack.add(temp.data);
                temp = temp.next;
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

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