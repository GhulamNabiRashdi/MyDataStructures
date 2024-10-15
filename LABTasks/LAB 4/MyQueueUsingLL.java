public class MyQueueUsingLL<T extends Comparable<T>> {
    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyQueueUsingLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
            return;

        }
    }

    public T dequeue() {
        if (head == null) {
            head = null;
            tail = null;
            size = 0;
            System.out.println("Stack is Empty");
            return null;
        } else {
            Node temp = head;
            head = head.next;
            size--;
            return temp.data;
        }
    }

    public T peek() {
        if (head == null) {
            System.out.println("Queue is Empty");
            return null;
        } else {
            return head.data;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("[]");
            return;
        } else {
            Node temp = head;
            System.out.print("[");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print("]");
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
        return;
    }
}
