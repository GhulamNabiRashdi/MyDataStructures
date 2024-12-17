public class Task4 {
    public static void mergeSort(int[]array){
        if(array.length > 1){
            int mid = array.length / 2;
            int[]left = new int[mid];
            int[]right = new int[array.length - mid];
            for(int i = 0; i < mid; i++){
                left[i] = array[i];
            }
            for(int i = mid; i < array.length; i++){
                right[i - mid] = array[i];
            }
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    private static void merge(int[]array, int[]left, int[]right){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                array[k] = left[i];
                i++;
                k++;
            }else{
                array[k] = right[j];
                j++;
                k++;
            }
        }
        while(i < left.length){
            array[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length){
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1}; //base case
        }
        mergeSort(nums);
        int maxIndex = nums.length -1; //last index
        int minIndex = 0; //first index
        for(int i = 0; i < nums.length; i++){ //loop through the array
            if(maxIndex == minIndex){ //if the max and min index are the same
                break; //break the loop
            }
            if(nums[maxIndex] + nums[minIndex] == target){ //if the sum of the max and min index is equal to the target
                return new int[]{minIndex, maxIndex, nums[minIndex], nums[maxIndex]};
            }
            else if(nums[maxIndex] + nums[minIndex] > target){ //if the sum of the max and min index is greater than the target
                maxIndex--;
            }
            else{
                minIndex++; //if the sum of the max and min index is less than the target
            }
        }
        return new int[]{-1, -1}; //if the sum of the max and min index is not equal to the target
                
    }
    public static void main(String[]args){
        System.out.println("Hello World!");
        //int[]Array = {1,2,3,4,5,6,7,8,9,10};
        int[]Array = {12, 7, 3, 19, 5, 1, 9, 15, 8, 6};

        int target = 17;
        int[]ans = twoSum(Array, target);
        System.out.println("Array indexes: "+ans[0] + " and " + ans[1]);
        System.out.println("Array values: "+ans[2] + " and " + ans[3]);
    }

           }

