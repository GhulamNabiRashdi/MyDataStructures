public class Task5 {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    public static void factorialUsingLoop(int n) {
        if (n == 0) {
            return;
        }
        for(int i = 1; i <= n; i++) {
            System.out.print(factorial(i) + " ");
        }
    }
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println("Hello World!");
    }
}
