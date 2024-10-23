package Recursion;

public class ArraySorted {
    

    public static boolean isArraySorted(int[]arr, int index){

        if (arr.length == 0 || arr.length == 1) {
            return true; // An empty or single-element array is always sorted
        }
               if(index == arr.length-1){
                return true;
               };

        if(arr[index]>arr[index+1] ){
            return false;
        };
        return isArraySorted(arr, index+1);
    }

    public static void main(String[] args) {
        ArraySorted arraySorted = new ArraySorted();

        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] unsortedArray = {3,1,7,8,6};

        System.out.println("Is the array sorted? " + isArraySorted(sortedArray,0));  // Output: true
        System.out.println("Is the array sorted? " + isArraySorted(unsortedArray,0));  // Output: false
    }

}
