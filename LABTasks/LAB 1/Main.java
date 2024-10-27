public class Main {
    public static int[] manipulateArray(int[] array) {
        int size = array.length;
        int j = size - 1;
        int k = 0;
        int[] arrayTemp = new int[size];
        for (int i = 0; i < size; i++) {
            if (array[i] % 2 != 0) {
                arrayTemp[j] = array[i];
                j--;
            } else {
                arrayTemp[k] = array[i];
                k++;
            }
        }
        return arrayTemp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 7, 2, 2, 7, 8, 9};
        array = Task4.manipulateArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}