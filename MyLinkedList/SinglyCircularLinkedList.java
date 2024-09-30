public class SinglyCircularLinkedList<t> {

    private class Node<t> {
        private t data;
        private Node next;

        public Node(t data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size = 0;
    public Node head2;

    public void addFirst(t data) {
        Node newNode = new Node<T>(data);

        if (head == null) {
            head = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void addLast(t data) {
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
            temp.next = head;
            size++;
        }
    }

    public t removeFront() {
        t data = null;
        data = (T) head.data;
        head = head.next;
        size--;
        return data;
    }

    public t removeLast() {
        t removed = null;

        if (head == null) {
            return removed;

        } else if (head.next == null) {
            removed = (t) head.data;
            head = null;
            size--;
            
            return removed;

        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            removed = (t) temp.next.data;
            temp.next = head;
            size--;
            

        }

        return removed;
    }

    public void printLinkedList() {
        if (head == null) {
            System.out.println("Link is Empty");
            return;
        } else {
            Node temp = head;
            while (temp.next != head) {
                System.out.print(temp.data + " ");
                temp = temp.next;

            }
            System.out.println(temp.data);
        }
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void addAtMiddle(int index, int data) {
        Node newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

        }
    }

    public boolean search(T element) {
        Node temp = head;
        for (int i = 0; i < size - 1; i++) {
            if (temp.data == element) {
                return true;

            }

        }
        return false;

    }
    public Node addNode(t data, Node head){
        Node newNode = new Node<T>(data);

        if(head == null){
            head = newNode;
        }
        else{
            Node temp = head;

            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }
    public void printLinkedList(Node head) {
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
    public Node reverseList(Node head){
        @SuppressWarnings("unchecked")
        t[]array = (t[]) new Object();
        Node temp = head;
        for(int i = size; i > 0 ; i--){
            array[i] = (T) temp.data;
            temp = temp.next;
        }
        temp = head;
        for(int i = 0; i < array.length; i++){
            temp.data = array[i];
            temp = temp.next;
        }
        return head;
    }



}