public class LinkedListWT<t extends Comparable<t>> {

    private class Node {
        private t data;
        private Node next;

        public Node(t data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;
    public Node head2;

    public void addFirst(t data) {
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
    // public Node addFirst(t data,Node head) {
    // Node newNode = new Node(data);

    // if (head == null) {
    // head = newNode;
    // size++;
    // } else {
    // newNode.next = head;
    // head = newNode;
    // size++;
    // }
    // return head;
    // }

    public void addLast(t data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            // index++;
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }

    }

    public t removeFront() {
        if (head == null) {
            head = null;
            tail = null;
            return null;
        }
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            t data = null;
            data = head.data;
            head = head.next;
            size--;
            return data;

        }
        return null;
    }

    public t removeLast() {
        t removed = null;

        if (head == null) {
            head = null;
            tail = null;
            return removed;

        }else if (head.next == null) {
            removed = head.data;
            head = null;
            size--;
            return removed;

        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            removed = temp.next.data;
            temp.next = null;
            tail = temp;
            return removed;

        }

    }

    public void printLinkedList() {
        if (head == null) {
            head = null;
            tail = null;
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

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;    
    }

    public void addAtMiddle(int index, t data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;

        }
    }

    public boolean search(t element) {
        Node temp = head;
        for (int i = 0; i < size - 1; i++) {
            if (temp.data == element) {
                return true;
            }
        }
        return false;

    }

    public Node addNode(t data, Node head) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size ++;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            tail = newNode;
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

    public Node reverseList(Node head) {
        if (head == null)
            return null;

        else {
            Node head2 = null;
            Node temp = head;

            while (temp != null) {
                head2 = addFirst( temp.data, head2);
                temp = temp.next;
            }
            return head2;
        }
    }

    public t nthNumberFromLastInList(int nthIndex, Node head) {
        if (head == null) {
            System.out.println("List is Empty");
            return null;
        }

        if (nthIndex < 0 || nthIndex >= size) {
            System.out.println("Invalid index");
            return null;
        }

        int i = size - 1;
        t returns = null;

        Node temp = head;
        while (temp != null && i >= 0) {
            if (i == nthIndex) {
                returns = (t) temp.data;
                break;
            }
            temp = temp.next;
            i--;
        }

        return returns;
    }

    public void sort() {
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return;
        }

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            Node current = head;
            while (current != null && current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    // Swap nodes
                    t temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        }
    }

    public void removeDuplicatesFromList(Node head) {
        if (head == null) {
            System.out.println("List IS Empty!");
            return;
        } else {
            Node temp = head;
            
            while (temp != null) {

            }
        }
    }

}