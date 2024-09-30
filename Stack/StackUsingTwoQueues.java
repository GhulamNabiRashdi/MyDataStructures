package Stack <T>;
public class StackUsingTwoQueues<T> {

    private MyQueue<T> queue1;
    private MyQueue<T> queue2;    
    private int size;

    public StackUsingTwoQueues() {
        queue1 = new MyQueue<>();
        queue2 = new MyQueue<>();
        size = 0;
    }

    public void push(T data) {
        queue1.enque(data);
        size++;
    }

    public T pop() {
        if (size == 0) {
            System.out.println("Stack is Empty");
            return null;
        } else {
            while (!queue1.isEmpty()) {
                queue2.enque(queue1.deque());
            }
            T returns = queue2.deque();
            size--;
            while (!queue2.isEmpty()) {
                queue1.enque(queue2.deque());
            }
            return returns;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() { 
        return size;
    }

    public void clear() {
        queue1.clear();
        queue2.clear();
        size = 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        } else {
            while (!queue1.isEmpty()) {
                queue2.enque(queue1.deque());
            }
            for (T element : queue2) {
                System.out.print(element + " ");
            }
            while (!queue2.isEmpty()) {
                queue1.enque(queue2.deque());
            }
        }
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        } else {
            while (!queue1.isEmpty()) {
                queue2.enque(queue1.deque());
            }
            T returns = queue2.peek();
            while (!queue2.isEmpty()) {
                queue1.enque(queue2.deque());
            }
            return returns;
        }
    }


}