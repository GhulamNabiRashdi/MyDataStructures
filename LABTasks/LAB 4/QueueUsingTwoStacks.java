import java.util.Stack;

public class QueueUsingTwoStacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;
    private int size;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        this.size = 0;
    }

    public void enque(T data) {
        stack1.push(data);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T deque() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            T returns = stack2.pop();
            size--;
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return returns;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            for (T element : stack2) {
                System.out.print(element + " ");
            }
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        stack1.clear();
        stack2.clear();
    }
    
}