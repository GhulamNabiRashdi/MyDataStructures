public class Main2 {
    public static void main(String[]args){
        LinkedListCustom<Integer> list = new LinkedListCustom<>();
        list.head2 = null;
        list.head2 = list.addNode(10, list.head2);
        list.head2 = list.addNode(3, list.head2);
        list.head2 = list.addNode(4, list.head2);
        list.head2 = list.addNode(5, list.head2);

        list.printLinkedList(list.head2);
        //list.head2 = list.reverseList(list.head2);
        //list.printLinkedList(list.head2);
        list.head2 = list.reverseList(list.head2);
        list.printLinkedList(list.head2);
        int bill = list.nthNumberFromLastInList(3,list.head2);
        System.out.println(bill);
    }
}       
