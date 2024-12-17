public class InsertionSort{
    static int comparasion = 0;
public static void insertionSort(int[]array){
    for(int i = 1; i < array.length; i++){
        int temp = array[i];
        int j = i - 1;
        while(j >= 0 && array[j] > temp){
            System.out.println(++comparasion + " Comparasion");
            array[j+1] = array[j];
            j--;
        }
        array[j+1] = temp;
    }
}

}