package Sorting;
public class Bubblesort {

    public static void Bubblesort(int[]arr){
        int n  = arr.length;
        boolean swapped;
        for(int i = 0;i<arr.length;i++){
            swapped = false;
            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        
    }
public static void main(String[] args) {
    
    int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();  // New line after printing the original array

        Bubblesort(arr);

        System.out.println("Sorted array:");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();  // New line after printing the sorted array
    }
}    










