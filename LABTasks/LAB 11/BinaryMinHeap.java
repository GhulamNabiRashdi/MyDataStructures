public class BinaryMinHeap<T extends Comparable<T>> {

    private T[] minHeap;
    private int maxSize;
    private int size;

    public BinaryMinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.minHeap = (T[]) new Comparable[maxSize];
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

    private void swap(T[] minHeap, int i, int j) {
        T temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }

    public void add(T data) {
        if ((size < maxSize)) {
            minHeap[size] = data;
            shiftUp(size);
            size++;
        } else {
            System.out.println("Heap is full");
            return;
        }
    }

    private void shiftUp(int current) {
        if (current != 0 && minHeap[parentIndex(current)].compareTo(minHeap[current]) > 0) {

            swap(minHeap, current, parentIndex(current));
            shiftUp(parentIndex(current));
        }

    }

    // private void shiftDown(int current) {
    // if (current != 0 &&
    // (minHeap[current].compareTo(minHeap[leftChildIndex(current)]) > 0
    // || minHeap[current].compareTo(minHeap[rightChildIndex(current)]) > 0)) {

    // if
    // (minHeap[leftChildIndex(current)].compareTo(minHeap[rightChildIndex(current)])
    // > 0) {
    // // T temp = minHeap[current];
    // // minHeap[current] = minHeap[parentIndex(current)];
    // // minHeap[parentIndex(current)] = minHeap[current];
    // swap(minHeap, current, leftChildIndex(current));
    // shiftDown(leftChildIndex(current));
    // } else {
    // swap(minHeap, current, rightChildIndex(current));
    // shiftDown(rightChildIndex(current));
    // }

    // }
    // }
    private void shiftDown(int current) {
        int leftIndex = leftChildIndex(current);
        int rightIndex = rightChildIndex(current);

        if (leftIndex == Integer.MIN_VALUE && rightIndex == Integer.MIN_VALUE)
            return;

        if (leftIndex != Integer.MIN_VALUE && (minHeap[current].compareTo(minHeap[leftIndex]) > 0 ||
                (rightIndex != Integer.MIN_VALUE && minHeap[current].compareTo(minHeap[rightIndex]) > 0))) {

            if (rightIndex != Integer.MIN_VALUE && minHeap[leftIndex].compareTo(minHeap[rightIndex]) > 0) {
                swap(minHeap, current, rightIndex);
                shiftDown(rightIndex);
            } else {
                swap(minHeap, current, leftIndex);
                shiftDown(leftIndex);
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T extractMin() {
        if (size > 0) {
            T result = minHeap[0];
            minHeap[0] = minHeap[size - 1];
            size--;
            shiftDown(0);

            return result;
        }
        return null;

    }

    public T getMin() {
        if (size > 0)
            return minHeap[0];

        return null;
    }

    public String toString() {
        String s = "";
        for (int j = 0; j < size; j++) {
            s += minHeap[j] + " ";
        }
        return s;
    }

    public T removeE(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        T removedData = minHeap[i];
        minHeap[i] = minHeap[size - 1];
        size--;
        shiftDown(i);
        return removedData;
    }

    public void changePriority(int i, T value) {
        if (i > size || i < 0) {
            System.out.println("Invalid Index");
            return;
        }
        minHeap[i] = value;
        if (minHeap[i].compareTo(minHeap[parentIndex(i)]) < 0) {
            shiftUp(i);
        } else {
            shiftDown(i);
        }

    }

    public void printHeap() {
        // int i = 0;
        // while(i != size){
        // System.out.print(minHeap[i] + " ");
        // i++;
        // }
        // System.out.println();
        // }
        for (T i : minHeap) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
    public int search(T data){
        int j = 0;

        for(T i : minHeap){
            
            if(i.compareTo(data) == 0){
                
                return j;
            }
           
            j++;
        }
        
        return -1;
    }

}
    