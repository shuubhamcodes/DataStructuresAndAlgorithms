package Sorting;

public class Insertionsort {
    public static int[] Insertionsort(int[]arr){
    for(int i = 1;i<arr.length;i++){
        int element = arr[i];
        int j = i-1;
    
        while(j>=0 && arr[j]>element){
            arr[j + 1] = arr[j];  // Shift elements to the right
                j = j - 1;
        }

        arr[j+1] =element;
    }
    return arr;
    }
    public static void main(String[] args){
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        int[] ans = Insertionsort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.println(ans[i]);
        }
    }




}






