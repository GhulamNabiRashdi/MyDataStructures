public class BinaryMaxHeap<T extends Comparable<T>> {

    private T[] maxHeap;
    private int maxSize;
    private int size;

    public BinaryMaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.maxHeap = (T[]) new Comparable[maxSize];
        this.size = 0;

    }

    private int parentIndex(int i) {
        if (i == -1) {
            return Integer.MIN_VALUE;
        }
        return (i - 1) / 2;
    }

    private int leftChildIndex(int i) {
        if (2 * i + 1 >= size) {
            return Integer.MIN_VALUE;
        }
        return 2 * i + 1;
    }

    private int rightChildIndex(int i) {
        if (2 * i + 2 >= size) {
            return Integer.MIN_VALUE;
        }
        return 2 * i + 2;
    }

   
    private void swap(T[] maxHeap, int i, int j) {
        T temp = maxHeap[i];
        maxHeap[i] = maxHeap[j];
        maxHeap[j] = temp;
    }

    public void add(T data) {
        if ((size < maxSize)) {
            maxHeap[size] = data;
            shiftUp(size);
            size++;
        }
        else{
            System.out.println("Heap is full");
            return;
        }
    }

    private void shiftUp(int current) {
        if (current != 0 && maxHeap[parentIndex(current)].compareTo(maxHeap[current]) < 0) {
         
            swap(maxHeap, current, parentIndex(current));
            shiftUp(parentIndex(current));
        }

    }

    // private void shiftDown(int current) {
    //     if (current != 0 && (maxHeap[current].compareTo(maxHeap[leftChildIndex(current)]) > 0
    //             || maxHeap[current].compareTo(maxHeap[rightChildIndex(current)]) > 0)) {

    //         if (maxHeap[leftChildIndex(current)].compareTo(maxHeap[rightChildIndex(current)]) > 0) {
    //             // T temp = maxHeap[current];
    //             // maxHeap[current] = maxHeap[parentIndex(current)];
    //             // maxHeap[parentIndex(current)] = maxHeap[current];
    //             swap(maxHeap, current, leftChildIndex(current));
    //             shiftDown(leftChildIndex(current));
    //         } else {
    //             swap(maxHeap, current, rightChildIndex(current));
    //             shiftDown(rightChildIndex(current));
    //         }

    //     }
    // }
    private void shiftDown(int current) {
        int leftIndex = leftChildIndex(current);
        int rightIndex = rightChildIndex(current);
    
        if (leftIndex == Integer.MIN_VALUE && rightIndex == Integer.MIN_VALUE) return;
    
        if (leftIndex != Integer.MIN_VALUE && (maxHeap[current].compareTo(maxHeap[leftIndex]) < 0 ||
            (rightIndex != Integer.MIN_VALUE && maxHeap[current].compareTo(maxHeap[rightIndex]) < 0))) {
    
            if (rightIndex != Integer.MIN_VALUE && maxHeap[leftIndex].compareTo(maxHeap[rightIndex]) < 0) {
                swap(maxHeap, current, rightIndex);
                shiftDown(rightIndex);
            } else {
                swap(maxHeap, current, leftIndex);
                shiftDown(leftIndex);
            }
        }
    }
    

    public boolean isEmpty() {
        return size == 0;
    }
    public T extractMax(){
        if(size > 0){
        T result = maxHeap[0];
        maxHeap[0] = maxHeap[size - 1];
        size--;
        shiftDown(0);

        return result;
    }
    return null;
    
    }
    public T getMax(){
        if(size > 0)
        return maxHeap[0];

        return null;
    }
    public String toString(){
        String s = "";
        for(int j = 0; j < size ; j++){
            s += maxHeap[j] + " ";
        }
        return s;
    }
    public T removeE(int i){
        if(i < 0 || i >= size){
            return null;
        }
        T removedData = maxHeap[i];
        maxHeap[i] = maxHeap[size - 1];
        size--;
        shiftDown(i);
        return removedData;
    }
    public void changePriority(int i, T value){
        if(i > size || i < 0){
            System.out.println("Invalid Index");
            return;
        }
        maxHeap[i] = value;
        if(maxHeap[i].compareTo(maxHeap[parentIndex(i)]) > 0){
            shiftUp(i);
        }
        else{
            shiftDown(i);
        }

    }



}

    
