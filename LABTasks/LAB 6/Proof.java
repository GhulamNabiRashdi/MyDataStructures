public class Proof {
    static int comparasion = 0;
    public static void bubbleSort(int[]array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    System.out.println(++comparasion + " Comparasion");
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        System.out.println("hello World!");
        int[]array = {9,3,6,1};
        bubbleSort(array);
    }
}
