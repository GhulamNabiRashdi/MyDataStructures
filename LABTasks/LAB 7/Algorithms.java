public class Algorithms {

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int low = 0;
        int high = array.length - 1;
        int middle = array.length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[array.length - middle];
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        mergeSortHelper(array, leftArray, rightArray);
    }

    private static void mergeSortHelper(int[] array, int[] leftArray, int[] rightArray) {
        int l = 0;
        int i = 0;
        int r = 0;

        while (l < leftArray.length && r < rightArray.length) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                r++;
                i++;
            }
        }
        while (l < leftArray.length) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightArray.length) {
            array[i] = rightArray[r];
            i++;
            r++;
        }

    }
    public static int printFabinacciSeries(int n) {
        if(n ==0 || n ==1 ){
            System.out.println(n);
            return n;
        }
        else{
            int arr[] = new int [2];
            arr[0] = printFabinacciSeries(n-1);
            arr[1] = printFabinacciSeries(n-2);

            for(int e : arr){
                System.out.print(e + " ");
            }
        }
        return 0;
        
        
    }

    public static void quickSort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = pivotFinder(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int pivotFinder(int[] array, int low, int high) {
        int pivot = array[high];
        int k = low - 1;
        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                k++;
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        int temp = array[k + 1];
        array[k + 1] = array[high];
        array[high] = temp;
        return k + 1;

    }

    public static void itterate(int[] array) {
        for (int e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("hello WOrld!");
        // int[] array = { 9, 3, 10, 1, 2, 4, 6, 8, 7, 5 };
        // itterate(array);
        // // mergeSort(array);
        // quickSort(array);
        // itterate(array);
        //System.out.println(printFabinacciSeries(10));
        

    }
}