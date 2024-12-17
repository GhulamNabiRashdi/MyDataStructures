public class Task2 {

    static int n = 0;
    public static void printArray(int[]arr){
        if(n == arr.length){
            return;
        }
        System.out.print(arr[n]+" ");
        n = n+1;
        printArray(arr);

     
    }
    public static void printArrayinReverse(int[]arr){
        if(n == arr.length){
            return;
        }
        else{
            n = n+1;
            printArrayinReverse(arr);
            n = n-1;
            System.out.print(arr[n]+" ");
        }
    }
    public static void main(String[]args){

        int[]Array ={1,2,3,4,5};
        //System.out.println();
        printArrayinReverse(Array);
        System.out.println();
        printArray(Array);
    }
}
