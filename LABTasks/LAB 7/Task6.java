public class Task6 {
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
    public static void main(String[] args) {
        LinkedListCustom<Integer> list = new LinkedListCustom();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);
        list.addFirst(60);

        long j = System.nanoTime();
        list.printLinkedList(list.head);
        long k = System.nanoTime();

        System.out.println("Time taken using for loop  in Ms: " + (k - j) * 0.001);

        j = System.nanoTime();
        list.printL();
        k = System.nanoTime();
        System.out.println("Time taken using recursion in Ms: " + (k - j)* 0.001);
        //list.printL();
    }
}
    