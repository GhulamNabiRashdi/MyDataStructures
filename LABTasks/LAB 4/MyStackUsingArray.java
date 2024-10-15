public class MyStackUsingArray<T> {
    private T[] array;
    private int size;
    private int index;
    private boolean isSizeDefined = false;

    
    public MyStackUsingArray(int size) {
        this.size = size;
        array = (T[]) new Object[size];
        this.index = -1;
        isSizeDefined = true;
    }

    
    public MyStackUsingArray() {
        this.size = 10;
        array = (T[]) new Object[size];
        this.index = -1;
        isSizeDefined = false;
    }

    public void add(T data) {
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

    public T top() {
        if(index == -1){
            System.out.println("Stack is Empty");
            return null;
        }
        T returnE;
        returnE = array[index];
        array[index] = null;
        index --;
        
        return returnE;
        
    }

    public T remove() {
        if (index * 2 < size -1) {
            shrink();
        }

        T element = array[index];
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
        for(T stack : array){
            if(stack != null)
            System.out.print(stack +" ");
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
            System.out.println("Stack is Empty");
            return null;
        }
        else{
            return array[index];
        }
    }

}