public class MyStackUsingLL<T> {

    private class Node{
        private T data;
        private Node next;
        
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
        private Node head;
        private int size;

        public MyStackUsingLL(){
            head = null;
            size = 0;
        }
        public void push(T data){
            Node newNode = new Node(data);

            if(head == null){
                head = newNode;
                size++;
                return;
            }
            else{
                newNode.next = head;
                head = newNode;
                return;
            }
        }
        public T pop(){
            if(head == null){
                head = null;
                size = 0;
                System.out.println("Stack is Empty");
                return null;
            }
            else{
                T returnE;
                returnE = head.data; 
                head = head.next;
                return returnE;
            }
            // if(head.next == null){
            //     Node temp = head;
            //     head = null;
            //     tail = null;
            //     size--;
            //     return temp.data;
            // }
            // else{
            //     Node temp = head;

            //     while(temp.next.next != null){
            //         temp = temp.next;
            //     }
            //     Node temp2 = temp.next;
            //     temp.next = null;
            //     tail = temp;
            //     size--;
            //     return temp2.data;

            // }
        }
        public T top(){
            if(head == null){
                System.out.println("Stack is Empty");
                return null;
            }
            else{
                return head.data;
            }
        }
        public void print(){
            if(head == null){
                System.out.println("[]");
                return;
            }
            else{
                Node temp = head;
                System.out.print("[");
                while(temp != null){
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                System.out.print("]");
            }
        }
        public boolean isEmpty(){
            return head == null;
        }
    }
    

