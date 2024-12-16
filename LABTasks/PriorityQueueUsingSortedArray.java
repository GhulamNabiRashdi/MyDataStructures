public class PriorityQueueUsingSortedArray<T extends Comparable<T>> {
    private T[] array;
    private int size;
    private int i;

    public PriorityQueueUsingSortedArray() {
        array = (T[]) new Object[10];
        size = -1;
        i = 0;
    }

    public void insert(T data) {
        if(size < array.length){
            if (size == -1) {
                array[i++] = data;
                size++;
            } else {
                if(data.compareTo(array[0]) > 0 ){
                    for(int i = array.length - 1; i >= 0; i--){
                        array[i] = array[i+1];
                    }
                    array[0] = data;
                }
                else{
                    int j = 0;
                    while(array[j].compareTo(data) < 0){
                        j++;
                    }
                    for(int i = array.length -1; i < 0; i--){
                        array[i] = array[i+1];
                    }
                    array[j] = data;

                }
            }
        }
        else{
            grow();
        }
        
    }

    private void grow() {
        T[] tempArray = (T[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

    private void shrink() {
        T[] tempArray = (T[]) new Object[array.length / 2];
        for (int i = 0; i < array.length / 2; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

    public T remove() {
        T ret = null;
        extractMax();

        return ret;
    }

    private T extractMax() {
        if(size == -1){
            System.out.println("Array is Empty");
            return null;
        }
        else{
            T ret = array[array.length -1];
            array[array.length - 1 ] = array[array.length -2];
            return ret;
        }
    }

    public T getMax() {
        if(size == -1){
            System.out.println("Array Is Empty");
            return null;
        }
        return array[array.length - 1];
    }

    public int searchData(T data) {

        for (int i = 0; i < array.length; i++) {
            if (data == array[i]) {
                return i;
            }
        }

        return -1;

    }
}
