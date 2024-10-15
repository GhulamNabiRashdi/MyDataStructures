public class Task2 {
    private static boolean hasElement(int key,int[]array){
        for(int i = 0; i< array.length; i++){
            if(array[i] == key){
                return true;
            }
        }
        return false;
    }
public static int[] noDup(int[][] array){
    int[] array2 = new int[20];
    int index = 0;
    for (int i = 0; i < array.length; i++){
        for(int j = 0; j < array[i].length; j++){
            int key = array[i][j];
            if(hasElement(key,array2)){
                continue;
            }
            else{
                array2[index++] = array[i][j];
            }
        }
    }

return array2;
}
 public static void main(String[] args){
    int[][] array = new int[4][5];
    int[] array2 = new int[20];

        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = (int) (Math.random() * 10);
            }
        }

        System.out.println("Original Array");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        array2 = noDup(array);
        System.out.println("After array");
        for (int i = 0; i < array2.length; i++){
            System.out.print(array2[i] + " ");
            
        }
        

 }   
}
