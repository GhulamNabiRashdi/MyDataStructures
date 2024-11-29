public class PriorityQueueUsingArray<T extends Comparable<T>> {
    private T[] array;
    private int size;
    private int i;

    public PriorityQueueUsingArray() {
        array = (T[]) new Object[10];
        size = -1;
        i = 0;
    }

    public void insert(T data) {
        if (size < array.length) {
            array[i++] = data;
            size++;
        } else {
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
        if (size == -1) {
            System.out.println("Array is Empty");
            return null;
        } else {
            T ret = array[0];

            int indexOfMax = 0;
            for (int i = 0; i < array.length; i++) {

                if (ret.compareTo(array[i]) < 0) {
                    ret = array[i];
                    indexOfMax = i;

                }

            }
            if (indexOfMax == array.length - 1) {
                return ret;
            } else {
                for (int i = indexOfMax; i < array.length; i++) {

                    array[indexOfMax] = array[indexOfMax + 1];
                }
                return ret;
            }
        }
    }

    public T getMax() {
        if (size == -1) {
            System.out.println("Array is Empty");
            return null;
        } else {
            T ret = array[0];

            int indexOfMax = 0;
            for (int i = 0; i < array.length; i++) {

                if (ret.compareTo(array[i]) < 0) {
                    ret = array[i];
                    indexOfMax = i;

                }

            }
            return ret;
        }
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