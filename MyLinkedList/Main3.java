public class Main3{
    public static void main(String[]args){
        DoublyLinkedlist<Integer> Dll = new DoublyLinkedlist<>();
        
        Dll.insertAtLast(1);
        Dll.insertAtLast(2);
        Dll.insertAtLast(3);
        Dll.insertAtLast(4);
        Dll.insertAtLast(5);
        Dll.insertAtLast(6);
        Dll.insertAtLast(7);
        Dll.insertAtBeginning(0);
        
        Dll.makeCercular();
        Dll.addAtIndex(4, 11);
        // Dll.removeFromLast();
        // Dll.removeFromLast();
        // Dll.removeFromLast();
        // Dll.removeFromBeginning();
        // Dll.removeFromBeginning();
        // Dll.removeFromBeginning();
        // Dll.removeFromLast();
        // Dll.removeFromBeginning();
        // Dll.removeFromBeginning();
        System.out.println("Before List");
        Dll.printList();
        Dll.printListReverse();
        //Dll.removeAtIndex(4);
        System.out.println("AfterList");
        Dll.printList();
        System.out.println("Size of List is = "+ Dll.size());
        System.out.println("Before:");
        System.out.println("Is Linked List Empty = "+ Dll.isEmpty() );
        //System.out.println(Dll.get(9));
        //System.out.println("Element 1000 is present in linked list is = " + Dll.contains(1000));
        // Dll.clearList();
        // System.out.println("After:");
        // System.out.println("Is Linked List Empty = "+ Dll.isEmpty() );
        // Dll.printList();
       int index =  Dll.indexOf(11);
       Dll.insertAtLast(1000);
       Dll.printList();
       System.out.println("Index of Element is = "+ index);
       Dll.insertAtBeginning(1020);
       Dll.printList();
       Dll.printListReverse();
       Dll.insertAtBeginning(100000);
       Dll.insertAtLast(1000001);
       Dll.insertElementBefore(90, 0);
       Dll.insertElementAfter(91, 90);
        Dll.printList();
        Node head = new Node(1);    
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;
        boolean hasCycle = head.hasCycle(head);
        System.out.println("Does Link has Cycle?: "+ hasCycle);
        boolean isCircular = Dll.isCircular();
        System.out.println(isCircular);
        Dll.head2 = null;
        

        
    }
}