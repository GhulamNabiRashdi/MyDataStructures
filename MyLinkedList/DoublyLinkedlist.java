public class DoublyLinkedlist<T extends Comparable<T>> {
    private class Node {
        private T data;
        private Node prev;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private int size;
    Node head2;
    private boolean isCircular = false;

    public void insertAtLast(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        } 
        else {
            if (!isCircular) {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
                size++;
                return;
            } else if (isCircular) {
                Node temp2 = head.prev;
                temp2.next = newNode;
                newNode.prev = temp2;
                newNode.next = head;
            }

        }
    }

    public void insertAtLast(Node head, T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        } else {
            if (isCircular != true) {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
                size++;
                return;
            } else if (isCircular) {
                Node temp2 = head.prev;
                temp2.next = newNode;
                newNode.prev = temp2;
                newNode.next = head;

            }

        }
    }

    public void insertAtBeginning(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        } else {
            if (isCircular != true) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                size++;
                return;
            } else if (isCircular) {
                Node temp = head.prev;
                head.prev = newNode;
                newNode.next = head;
                temp.next = newNode;
                newNode.prev = temp;
                head = newNode;

            }
        }
    }

    public void insertAtBeginning(Node head, T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        } else {
            if (isCircular != true) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                size++;
                return;
            } else if (isCircular) {
                Node temp = head.prev;
                head.prev = newNode;
                newNode.next = head;
                temp.next = newNode;
                newNode.prev = temp;
                head = newNode;

            }
        }
    }

    public void removeFromLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        } else {
            if (isCircular != true) {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
                size--;
                return;
            } else if (isCircular) {
                Node temp = head.prev.prev;
                temp.next = head;
                head.prev = temp;
                size--;
                return;
            }
        }
    }

    public void removeFromLast(Node head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        } else {
            if (isCircular != true) {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
                size--;
                return;
            } else if (isCircular) {
                Node temp = head.prev.prev;
                temp.next = head;
                head.prev = temp;
                size--;
                return;
            }
        }
    }

    public void removeFromBeginning() {
        if (head == null) {
            head = null;
            return;
        } else if (head.next == null) {
            head = head.next;
            size--;
            return;
        } else {
            if (isCircular != true) {
                head = head.next;
                head.prev = null;
                size--;
                return;
            } else if (isCircular) {
                Node temp = head.prev;
                head = head.next;
                head.prev = temp;
                temp.next = head;
            }
        }

    }

    public void removeFromBeginning(Node head) {
        if (head == null) {
            head = null;
            return;
        } else if (head.next == null) {
            head = head.next;
            size--;
            return;
        } else {
            if (isCircular != true) {
                head = head.next;
                head.prev = null;
                size--;
                return;
            } else if (isCircular) {
                Node temp = head.prev;
                head = head.next;
                head.prev = temp;
                temp.next = head;
            }
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        if (head == null) {
            System.out.println("Link is Empty");
            return;
        } else {
            if (isCircular != true) {
                Node temp = head;
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }

                System.out.println();
            }
            if (isCircular) {
                Node temp = head;
                while (temp.next != head) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }

                System.out.println();
            }

        }
    }

    public void printList(Node head) {
        if (head == null) {
            System.out.println("Link is Empty");
            return;
        } else {
            if (isCircular != true) {
                Node temp = head;
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }

                System.out.println();
            }
            if (isCircular) {
                Node temp = head;
                while (temp.next != head) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }

                System.out.println();
            }

        }
    }

    public void printListReverse() {
        if (head == null) {
            System.out.println("Link is Empty");
            return;
        } else {
            if (isCircular != true) {
                Node temp = head;
                while (temp.next != null) {

                    temp = temp.next;
                }

                while (temp != head) {
                    System.out.print(temp.data + " ");
                    temp = temp.prev;
                }
                System.out.print(head.data + " ");
                System.out.println();
            } else if (isCircular) {
                Node temp = head.prev;
                while (temp != head) {
                    System.out.print(temp.data + " ");
                    temp = temp.prev;
                }
                System.out.print(temp.data);
                System.out.println();
            }
        }
    }
    public void printListReverse2() {
        if(head == null){
            System.out.println("Link is Empty");
            return;
        }else{
            Node current = head;
            Node next = current.next;
            Node prev = current.prev;
           
            while(current !=null){
                next = current.next;
                prev = current.prev;
                current.next = prev;
                current.prev = next;
                current = next;
                

            }
            
        }
    }

    public void printListReverse(Node head) {
        if (head == null) {
            System.out.println("Link is Empty");
            return;
        } else {
            if (isCircular != true) {
                Node temp = head;
                while (temp.next != null) {

                    temp = temp.next;
                }

                while (temp != head) {
                    System.out.print(temp.data + " ");
                    temp = temp.prev;
                }
                System.out.print(head.data + " ");
                System.out.println();
            } else if (isCircular) {
                Node temp = head.prev;
                while (temp != head) {
                    System.out.print(temp.data + " ");
                    temp = temp.prev;
                }
                System.out.print(temp.data);
                System.out.println();
            }
        }
    }

    public void addAtIndex(int index, T element) {
        if (index > size || index < 0) {
            System.out.println("Invalid Index");
            return;
        }
        if (index == 0) {
            insertAtBeginning(element);
            size++;
        }
        if (index == size) {
            insertAtLast(element);
            size++;
        } else {
            Node newNode = new Node(element);
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
            size++;
        }
    }

    public void removeAtIndex(int index) {
        if (index > size || index < 0) {
            System.out.println("Invalid Index");
            return;
        }
        if (index == 0) {
            removeFromBeginning();
            size--;
        }
        if (index == size) {
            removeFromLast();
            size--;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of Bound");
            return null;
        } else if (index == 0) {
            return head.data;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    public boolean contains(T element) {
        if (head == null) {
            return false;
        }
        // if(head.data == element){
        // return true;
        // }
        else {
            if (isCircular != true) {
                Node temp = head;
                while (temp.next != null) {
                    if (temp.data == element) {
                        return true;
                    } else {
                        temp = temp.next;
                    }
                }
            } else if (isCircular) {
                Node temp = head;
                while (temp.next != head) {
                    if (temp.data == element) {
                        return true;
                    } else {
                        temp = temp.next;
                    }
                }
            }
        }
        return false;
    }

    public boolean contains(Node head, T element) {
        if (head == null) {
            return false;
        }
        // if(head.data == element){
        // return true;
        // }
        else {
            if (isCircular != true) {
                Node temp = head;
                while (temp.next != null) {
                    if (temp.data == element) {
                        return true;
                    } else {
                        temp = temp.next;
                    }
                }
            } else if (isCircular) {
                Node temp = head;
                while (temp.next != head) {
                    if (temp.data == element) {
                        return true;
                    } else {
                        temp = temp.next;
                    }
                }
            }
        }
        return false;
    }

    public void clearList() {
        head = null;
        size = 0;
        return;
    }

    public int indexOf(T element) {
        if (head == null) {
            return -1;
        } else {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.data == element) {
                    return i;
                } else {
                    temp = temp.next;
                }
            }
        }
        return -1;
    }

    public void makeCercular() {
        if (head == null) {
            return;
        }
        if (isCircular) {
            System.out.println("Link is Already Circular");
            return;
        }

        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = head;
            head.prev = temp;
            isCircular = true;
        }
    }

    public void insertElementBefore(T insertElement, T linkElement) {
        Node newNode = new Node(insertElement);
        if (head == null) {
            System.out.println("Link is Empty");
            return;

        }
        if (head.data == linkElement) {
            Node temp = head.prev;
            newNode.next = head;
            newNode.prev = temp;
            temp.next = newNode;
            head.prev = newNode;
            head = newNode;
        }

        else {
            Node temp = head;
            while (temp.next != head) {
                if (temp.next.data == linkElement) {
                    newNode.prev = temp;
                    temp.next.prev = newNode;
                    newNode.next = temp.next;
                    temp.next = newNode;
                    return;
                }
                temp = temp.next;
            }

            System.out.println("Given Element is not present in the List");
        }

    }

    public void insertElementAfter(T insertElement, T linkElement) {
        Node newNode = new Node(insertElement);
        if (head == null) {
            System.out.println("Link is Empty");
            return;

        }
        if (head.data == linkElement) {
            Node temp = head;
            newNode.prev = head;
            newNode.next = temp.next;
            temp.next.prev = newNode;
            head.next = newNode;
        }

        else {
            Node temp = head;
            while (temp.next != head) {
                if (temp.data == linkElement) {
                    newNode.prev = temp;
                    temp.next.prev = newNode;
                    newNode.next = temp.next;
                    temp.next = newNode;
                    return;
                }
                temp = temp.next;
            }

            System.out.println("Given Element is not present in the List");
        }

    }

    public boolean hasCycle(Node head) {
        if (head == null || head.next == null)
            return false;
        else {
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isCircular() {
        return isCircular;
    }
    // public void reverse(){
    // if (head == null){
    // return;
    // }
    // else{
    // Node temp = head;
    // Node head2;
    // while (temp.next != head){
    // head2.data =
    // }
    // }
    // }

}
