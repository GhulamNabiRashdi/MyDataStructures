import java.util.Random;

public class Task2Modified {
    private static boolean hasElement(int key, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return true;
            }
        }
        return false;
    }

    public static int[] removeDuplicates(int[][] array) {
        int[] uniqueElements = new int[20];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int key = array[i][j];
                if (!hasElement(key, uniqueElements)) {
                    uniqueElements[index++] = key;
                }
            }
        }
        int[] result = new int[index];
        System.arraycopy(uniqueElements, 0, result, 0, index);
        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[4][5];

        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = random.nextInt(10);
            }
        }

        System.out.println("Original array:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int[] uniqueElements = removeDuplicates(array);
        System.out.println("Unique elements:");
        for (int element : uniqueElements) {
            System.out.print(element + " ");
        }
    }
}