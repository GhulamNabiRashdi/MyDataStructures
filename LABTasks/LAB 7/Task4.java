public class Task4 {
    
public static void main(String[] args) {
    printFabunacciSeries(10);
}

private static void printFabunacciSeries(int i) {
    int a = 0;
    int b = 1;
    int c = 0;
    for (int j = 0; j < i; j++) {
        System.out.print(a + " ");
        c = a + b;
        a = b;
        b = c;
    }
    System.out.println();
}

}   