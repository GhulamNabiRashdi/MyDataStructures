public class Task7 {
    public static int searchUsingRecurssion(int[] arr, int target) {
        if(arr.length == 0){
            return -1;
        }
        int n = 0;
        int m = arr.length - 1;
        return search(arr, target, n, m);
        
        
    }
    private static int search(int[] arr, int target, int n, int m) {
        if(n > m){
            return -1;
        }
        int mid = (n + m) / 2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] > target){
            return search(arr, target, n, mid - 1);
        }
        else{
            return search(arr, target, mid + 1, m);
        }
    }
    public static int searchUsingLoop(int[] arr, int target) {
        if(arr.length == 0){
            return -1;
        }
        int n = 0;
        int m = arr.length - 1;
        while(n <= m){
            int mid = (n + m) / 2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                m = mid - 1;
            }
            else{
                n = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]array = {1, 2, 3, 5, 7, 2, 2, 7, 8, 9};
        int target = 9;
        long k = System.nanoTime();
        System.out.println(searchUsingRecurssion(array, target));
        long j = System.nanoTime();
        System.out.println("Time taken using recursion in Ms: " + (j - k) * 0.001);

        k = System.nanoTime();
        System.out.println(searchUsingLoop(array, target));
        j = System.nanoTime();
        System.out.println("Time taken using loop in Ms: " + (j - k) * 0.001);
        
    }
}
