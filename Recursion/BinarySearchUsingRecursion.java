package Recursion;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 55, 60}; // Sorted array
        int target = 55;
        int result = search(arr, target, 0, arr.length - 1);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }

    static int search(int arr[],int target, int s, int e){
        if(s>e){
            return-1;
        }
        int m = s+(e-s)/2;
        if(arr[m]== target){
            return m;
        }
        if(target<arr[m]){
            return search(arr,target,s,m-1);

        }
        return search(arr, target, m + 1, e);
    }
}
