
interface List {

    public boolean isEmpty();

    public int size();

    public void add(Object item);

    public void add(int index, Object item);

    public void remove(int index);

    public void remove(Object item);

    public List duplicate();

    public List duplicateReversed();

}

public class LLInterfaceImplementation implements List {

    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void add(Object item) {
        Node newNode = new Node(item);

        if (head == null) {
            head = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void add(int index, Object item) {
        if(index < 0 || index > size){
            System.out.println("Invalid Index ");
            return;
        }
        Node newNode = new Node(item);
        if(index == 0){
            newNode.next = head;
            head = newNode;
        }
        
         else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;

        }
        size++;

    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    public void remove(Object item) {
        if (head == null) {
            return;
        }

        if (head.data == item) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == item) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }

    }

    public List duplicate() {
        LLInterfaceImplementation newList = new LLInterfaceImplementation();
        Node temp = head;
        while(temp != null) {
            newList.add(temp.data);
            temp = temp.next;
        }
        return newList;
    }

    public List duplicateReversed() {
        LLInterfaceImplementation newList = new LLInterfaceImplementation();
        Node temp = head;
        while(temp != null) {
            newList.add(0, temp.data);
            temp = temp.next;
        }
        return newList;
    }

}
