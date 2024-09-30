// // // // class Solution {
// // // //     public int strStr(String haystack, String needle) {
// // // //         int index = -1;
// // // //         for (int i = 0; i < haystack.length();) {
// // // //             if(i + needle.length() >= haystack.length() ){
// // // //                 return index;
// // // //             }
// // // //             if (haystack.substring(i, needle.length()).equals(needle)) {
// // // //                 return i;
// // // //             }
// // // //             else{
// // // //                 i = needle.length()+1;
// // // //             }   
            
// // // //         }
// // // //         return index;
// // // //     }
    
// // // //     public static void main(String[] args) {
// // // //         Solution solution = new Solution();
// // // //         int j = 0;
// // // //        j =  solution.strStr("Hello", "ll");

// // // //         System.out.println("hello World!");

// // // //         System.out.println(j);

// // // //     }

// // // // }
// // // class Solution {
// // //     public int[] getConcatenation(int[] nums) {
// // //         int size = nums.length;
// // //         int[] newArray = new int[size*2];
    
// // //         for (int i = 0; i < nums.length ; i++){
// // //             newArray[i] = nums[i];
// // //         }

// // //         for(int i = 0; i < nums.length; i++){
// // //             newArray[i+ size] = nums[i];
// // //         }
// // //         return newArray;
// // //     }
    

// // // public static void main(String[]args){
// // //     System.out.println("Hello WOrld!");
// // //     Solution solution = new Solution();
// // //     int[]array = {1,2,3};
// // //     int[]array2 = new int[6];
// // //     array = solution.getConcatenation(array);
// // //     for(int i = 0; i < array.length; i++){
// // //         System.out.print(array[i] + " ");
// // //     }
// // // }
// // // }
// // class Solution {
// //     public int[] shuffle(int[] nums, int n) {

// //         int[] newArray = new int[nums.length];
// //         int a = nums.length/2;
        
// //         return new int[];
// //     }   
// // }
// class Solution {
//     public int[] shuffle(int[] nums, int n) {
//         int length1 = nums.length/2;
//         int[]array = new int[nums.length];
//         int[]array2 = new int[length1];
//         int j = length1;
//         int k = 0;
//         int l = 0;
        

//         for(int i = 0; i < length1; i++ ){
//             array2[i] = nums[j++];
//         }
//         for(int i = 0 ; i < nums.length; i++){
//             if(i%2 != 0){
//                 array[i] = array2[k++];
//             }
//             else{
//                 array[i] = nums[l++];
//             }
//         }
//         return array;
//     }
// }


//    class ListNode {
//       int val;
//      ListNode next;
//       ListNode() {}
//      ListNode(int val) {
//          this.val = val; 
//          }
//      ListNode(int val, ListNode next) { 
//     this.val = val; 
//     this.next = next; 
//     }
//   }
 


// class Solution {
//     public int getDecimalValue(ListNode head) {
//         listNode temp = head;
//         int size = 0;
//         while(temp!=null){
//             size++;
//             temp = temp.next;
//         }
//         temp = head;
//         int i = size -1;

//         while(temp.next != null){
//             Math.pow(size, i)
//         }
//     }
//     //Reverse a linked list usng an array or reverse a linked list using nested for loop
    
// }
class Solution {
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp.next != null){
            size++;
            temp = temp.next;

        }
        temp = head;
        for(int i = 0; i < size/2; i++){
            temp = temp.next;
        }
        if(size % 2 != 0){
        return temp;
    }
        
        else{
            return temp.next;
    }
}
}