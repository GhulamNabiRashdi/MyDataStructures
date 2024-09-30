public class DoublyLL {

    private class Node {
        private String data;
        private Node prev;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private int size;
    private boolean isCircular = false;


    public void insertAtBeginning(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            if (isCircular) {
                Node temp = head.prev;
                newNode.next = head;
                newNode.prev = temp;
                temp.next = newNode;
                head.prev = newNode;
                head = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }
    }
    public void insertAtBeginning(Node head,String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            if (isCircular) {
                Node temp = head.prev;
                newNode.next = head;
                newNode.prev = temp;
                temp.next = newNode;
                head.prev = newNode;
                head = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }
    }


    
    public void insertAtEnd(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            if (isCircular) {
                Node temp = head.prev;
                temp.next = newNode;
                newNode.prev = temp;
                newNode.next = head;
                head.prev = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
            }
            size++;
        }
    }
    public void insertAtEnd(Node head,String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            if (isCircular) {
                Node temp = head.prev;
                temp.next = newNode;
                newNode.prev = temp;
                newNode.next = head;
                head.prev = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
            }
            size++;
        }
    }



    public void insertBeforeString(String insertData, String existingData) {
        Node newNode = new Node(insertData);
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data.equals(existingData)) {
            if (isCircular) {
                Node temp = head.prev;
                newNode.next = head;
                newNode.prev = temp;
                temp.next = newNode;
                head.prev = newNode;
                head = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        } else {
            Node temp = head;
            while (temp.next != null && (isCircular ? temp.next != head : true)) {
                if (temp.next.data.equals(existingData)) {
                    newNode.next = temp.next;
                    temp.next.prev = newNode;
                    newNode.prev = temp;
                    temp.next = newNode;
                    size++;
                    return;
                }
                temp = temp.next;
            }
            if (isCircular && temp.data.equals(existingData)) {
                newNode.next = temp;
                temp.prev.next = newNode;
                newNode.prev = temp.prev;
                temp.prev = newNode;
                size++;
            } else {
                System.out.println("Existing data not found");
            }
        }
    }

    
    public void insertAfterString(String insertData, String existingData) {
        Node newNode = new Node(insertData);
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp.next != null && (isCircular ? temp.next != head : true)) {
            if (temp.data.equals(existingData)) {
                newNode.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = newNode;
                }
                newNode.prev = temp;
                temp.next = newNode;
                if (isCircular && temp == head.prev) {
                    newNode.next = head;
                    head.prev = newNode;
                }
                size++;
                return;
            }
            temp = temp.next;
        }
        if (isCircular && temp.data.equals(existingData)) {
            newNode.next = temp.next;
            temp.next.prev = newNode;
            newNode.prev = temp;
            temp.next = newNode;
            size++;
        } else {
            System.out.println("Existing data not found");
        }
    }


    public void printAll() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    
    public void makeCircular() {
        if (head == null) {
            return;
        }
        if (isCircular) {
            System.out.println("List is already circular");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head.prev = temp;
        isCircular = true;
    }

}