public class Main {
    public static int[] twoSum(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1}; //base case
        }
        int maxIndex = nums.length -1; //last index
        int minIndex = 0; //first index
        for(int i = 0; i < nums.length; i++){ //loop through the array
            if(maxIndex == minIndex){ //if the max and min index are the same
                break; //break the loop
            }
            if(nums[maxIndex] + nums[minIndex] == target){ //if the sum of the max and min index is equal to the target
                return new int[]{minIndex, maxIndex};
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
        int[]Array = {1,2,3,4,5,6,7,8,9,10};
        int target = 10;
        int[]ans = twoSum(Array, target);
        System.out.println("Array indexes: "+ans[0] + " and " + ans[1]);
    }

           }

