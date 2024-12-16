public class Task1 {
    
    public static void printNumbers(int n) {
        if (n >= 0) {
            // System.out.println(n);
            System.out.print(n + " ");
            
            printNumbers(n-1);
            System.out.print(n + " ");
        }
        else{
            System.out.println();
            return;
        }

    }
    

    public static void main(String[] args) {
        printNumbers(10);
        
    }
}