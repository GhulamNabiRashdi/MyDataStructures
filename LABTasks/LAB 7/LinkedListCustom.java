import java.util.Stack;

public class LinkedListCustom<t> {

    private class Node {
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
    public Node addFirst(t data,Node head) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
        return head;
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
            size++;
        }
    }

    public t removeFront() {
        t data = null;
        data = (t) head.data;
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
          //  index--;
            return removed;

        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            removed = (t) temp.next.data;
            temp.next = null;
            size--;
           // index--;

        }

        return removed;
    }

    public void printLinkedList() {
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
    public Node addNode(t data, Node head){
        Node newNode = new Node(data);

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
    // public Node reverseList(Node head){
    //     @SuppressWarnings("unchecked")
    //     T[] array = (T[]) new Object[this.size];
    //     Node temp = head;
    //     for(int i = size ; i > 0 ; i--){
    //         array[i] = (T) temp.data;
    //         temp = temp.next;
    //     }
    //     temp = head;
    //     for(int i = 0; i < array.length; i++){
    //         temp.data = array[i];
    //         temp = temp.next;
    //     }
    //     return head;
    // }
    public Node reverseList(Node head){
        if(head == null)return null;
        
        else{
            Node head2 = null;
            Node temp = head;

            while(temp!= null){
                head2 = addFirst((t) temp.data,head2);
                temp = temp.next;
            }
            return head2;
        }
    }
    public void Reverse(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        else{
            Node current = head;
            Node prev = null;
            Node next = null;
            while(current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            Node head2 = prev;
           // printLinkedList(head2);
        }
    }
    public void printInReverseOrder(){
        if(head == null){
            return;
        }
        else{
            Stack<t> stack = new Stack<>();
            Node temp = head;
            while(temp != null){
                stack.add(temp.data);
                temp = temp.next;
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop() + " ");
            }
        }
    }

    public void printL(Node head){
        if(head == null){
        System.out.println();
        return;  
    }
        else{
            System.out.print(head.data + " ");
            printL(head.next);
          //  System.out.println();
            System.out.print(head.data + " ");
            
        }
    }
    public void printL(){
       // if(head == null)return ;
        printL(head);
    }
    // public T nthNumberFromLastInList(int nthIndex){
    //     int i = size -1;
    //     t message = (T) "List is less than the index";
    
    //     if(head == null)System.out.println("List is Empty");
    //     else{
    //         Node temp = head;
    //         while(temp != null){
    //             if(i == nthIndex){
    //                 return (t) temp.data; 
                    
    //             }
    //             temp = temp.next;
    //             i--;
                

    //         }
            
            
    //     }
    //     return message;
        
    // }
    // public t nthNumberFromLastInList(int nthIndex) {
    //     int i = size - 1;

    //      t returns = null;
    
    //     if (head == null) {
    //         System.out.println("List is Empty");
    //         return null;
    //     }
    
    //     Node temp = head;
    //     while (temp != null && i >= 0) {
    //         if (i == nthIndex) {
    //             //return (T) temp.data;
    //             returns = (t) temp.data;
    //             break;
    //         }
    //         temp = temp.next;
    //         i--;
    //     }
    
    //     return returns;
    // }
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
    //public Node Sort(Node head){
        
    //     if(head == null)return null;
    //     else{
    //         Node head2 = head;
    //         Node temp = head;

    //         if(temp.next)
            
    //     }
    // }
//     public void sort() {
//     if (head == null) {
//         System.out.println("LIST_EMPTY");
//         return;
//     }

//     boolean swapped = true;
//     while (swapped) {
//         swapped = false;
//         Node current = head;
//         while (current != null && current.next != null) {
//             if ( (t) current.data > (t) current.next.data) {
//                 // Swap nodes
//                 int temp = (int) current.data;
//                 current.data = (t) current.next.data;
//                 current.next.data = temp;
//                 swapped = true;
//             }
//             current = current.next;
//         }
//     }
// }

    
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
            if ((t) current.data >(t) current.next.data) {
                // Swap nodes
                t temp = (t) current.data;
                current.data = current.next.data;
                current.next.data = temp;
                swapped = true;
            }
            current = current.next;
        }
    }
}
    public void removeDuplicatesFromList(Node head){
        if (head == null){
            System.out.println("List IS Empty!");|
            return;
        }
        else{
            Node temp = head;
            

            while(temp != null){
                
            }
        }
    }


}   