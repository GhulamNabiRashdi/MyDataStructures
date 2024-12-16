public class DynamicArray<T extends Comparable<T>> {

    private T[] array;
    private int size;
    private int maxSize = 10;

    public DynamicArray(int maxSize) {
        this.maxSize = maxSize;
        this.array = (T[]) new Comparable[maxSize];
        this.size = 0;
    }

    public DynamicArray() {
        this(10);
    }

    public void add(T data) {
        if (size == maxSize) {
            grow();
        }
        array[size++] = data;
    }

    public T remove() {
        if (isEmpty()) {
            System.out.println("Array is Empty ");
            return null;
        }
        if (size < maxSize / 2 && maxSize > 10) {
            shrink();
        }
        T result = array[--size];
        array[size] = null;
        //--size;
        return result;
    }

   

    private void shrink() {
        maxSize = maxSize / 2;
        T[] array2 = (T[]) new Comparable[maxSize];
        int j = 0;
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[i];
        }
        array = array2;

    }

    private void grow() {

        maxSize = maxSize * 2;
        T[] array2 = (T[]) new Comparable[maxSize];
        
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }
    public String toString(){
        String s = "";
        for(T i : array){
            s = i+" ";
        }
        return s;
    }
    public void print(){
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public int size(){
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int getIndexOf(T data){
        for(int i = 0; i < size; i++){
            if(array[i] == data){
                System.out.println("Index of "+data+" is "+i);
                return i;
            }
        }
        return -1;
    }
    public boolean contains(T data){
        for(int i = 0; i < size; i++){
            if(array[i] == data){
                return true;
            }
        }
        return false;
    }
    public void set(int index, T data){
        if(index < 0 || index >= size){
            System.out.println("Index out of bound");
            return;
        }
        array[index] = data;
    }
    public void insert(int index, T data){
        if(index < 0 || index >= size){
            System.out.println("Index out of bound");
            return;
        }
        if(size == maxSize){
            grow();
        }
        for(int i = size; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = data;
        size++;
    }
    public T delete(int index){
        if(index < 0 || index >= size){
            System.out.println("Index out of bound");
            return null;
        }
        if(size < maxSize/2 && maxSize > 10){
            shrink();
        }
        T result = array[index];
        for(int i = index; i < size-1; i++){
            array[i] = array[i+1];
        }
        array[size-1] = null;
        size--;
        return result;
    }
    
    
    public static void main(String[] args) {
        DynamicArray<Integer>list = new DynamicArray<>();
        list.add(10);
        list.add(20);
        // list.add(20);
        // list.add(30);
        // list.add(40);
        // list.add(40);
        // list.add(40);
        // list.add(40);
        // list.add(40);
        // list.add(40);
        // list.add(40);
        // list.add(40);
        // //System.out.println("Size of Array ");
        //System.out.println(list.get());
        list.print();
        // list.remove();
        // list.remove();
        // list.remove();
        
        System.out.println(list.remove());
        list.print();
      //  System.out.println("Size of Array");
       // System.out.println(list.get());

        //System.out.println(list);
    }

}