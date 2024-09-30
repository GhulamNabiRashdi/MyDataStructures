public class Main {
    public static void main(String[]args){
       // MyQueueUsingArray<Integer> queue = new MyQueueUsingArray<>();
       QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);
        // queue.deque();
        // queue.deque();
        // queue.deque();
        // queue.deque();
        // queue.deque();
        // queue.deque();
        queue.enque(1);
        queue.deque();
        queue.print();


    }
}
