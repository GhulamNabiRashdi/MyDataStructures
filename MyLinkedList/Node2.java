public class Node2  {
    private int data;
    Node2 next;
    
    public Node2(int data){
        this.data = data;
        this.next = null;
    }
    public boolean hasCycle(Node2 head){
        if(head == null || head.next == null)return false;
        else{
            Node2 slow = head;
            Node2 fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast){
                    return true;
                }
            }
            return false;
        }
    }

}
