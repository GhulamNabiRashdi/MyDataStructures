
public class Main {
    static boolean isSorted = false;
    
    public static void main(String[]args){
    // MyStackUsingArray<Integer> stack = new MyStackUsingArray<>();
    // stack.add(1);
    // stack.add(2);
    // stack.add(3);
    // stack.add(4);
    // stack.add(6);
    // stack.add(7);
    // stack.add(8);
    // stack.add(9);
    // stack.add(10);
    // stack.add(11);
    // stack.add(12);
    // stack.add(13);
    // System.out.println("Hello World!");    
    // stack.remove();
    // stack.remove();
    // stack.remove();
    // stack.remove();
    // stack.remove();
    // stack.remove();
    // System.out.println(stack.contains(3));
    
    // System.out.println(stack.top());
    // stack.print();
    MyStackUsingLL<Integer> stack = new MyStackUsingLL<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.pop();
    stack.print();
    System.out.println(stack.top());

    int[]array = {8,5,7,3,2,4,1,9,6};
    bubbleSort(array);
    for(int i = 0; i < array.length; i++){
        System.out.print(array[i] + " ");
    }
}   
}
    