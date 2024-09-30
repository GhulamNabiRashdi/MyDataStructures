public class MyQueueUsingArray<T> {
    private T[] array;
    private int size;
    private int index;
    private boolean isSizeDefined = false;

    
    
    public MyQueueUsingArray() {
        this.size = 10;
        array = (T[]) new Object[size];
        this.index = -1;
        isSizeDefined = false;
    }

    public void enque(T data) {
        if (index == size - 1) grow();

            array[++index] = data;
            return;
        
        }
    

    private void grow() {
        size = size * 2;
        T[] array2 = (T[]) new Object[size];
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        array = array2;
        return;
    }

    public boolean isEmpty() {
        return index == -1;
    }

    

    public T deque() {
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return null;
        }
        if (index * 2 < size -1) {
            shrink();
        }

        T element = array[0];
        for(int i = 0; i < index; i++){
            array[i] = array[i+1];
        }
        array[index] = null;
        index--;
        return element;

    }

    private void shrink() {
        size = size / 2;
        T[] array2 = (T[]) new Object[size];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[i];
        }
        array = array2;
        return;
    }
    public void print(){
        if(index == -1){
            System.out.println("[]");
            return;
        }
        for(T Queue : array){
            if(Queue != null)
            System.out.print(Queue +" ");
        }
    }
    public int size(){
        return index + 1;
    }
    public void clear(){
        index = -1;
        size = 0;
        array = null;
        return;

    }
    public boolean contains(T data){
        for(int i = 0; i < array.length; i++){
            if(array[i] == data){
                return true;
            }
            
        }
        return false;
    }
    public T peek(){
        if(index < 0){
            System.out.println("Queue is Empty");
            return null;
        }
        else{
            return array[0];
        }
    }

}