package Sorting;

public class SelectionSort {

    // Method to perform the selection sort by selecting the largest element
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = n - 1; i > 0; i--) {
            // Find the largest element in unsorted array
            int max_idx = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[max_idx]) {
                    max_idx = j;
                }
            }

            // Swap the found maximum element with the element at current end of the array
            int temp = arr[max_idx];
            arr[max_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Original array:");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();  // New line after printing the original array

        selectionSort(arr);

        System.out.println("Sorted array:");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();  // New line after printing the sorted array
    }
}





// Selection Sort Algorithm: Find the Maximum
// Step 1: Initialize Ending Point
// Start by assuming the last element of the array is the largest. Set a variable, typically called max_idx, to the index of this element, which is arr.length - 1 for the first iteration.
// Step 2: Search for the Largest Element
// Compare this element with the others in the unsorted part of the array to find the actual largest element.
// Step 3: Loop Through the Array
// Loop through the array from the first element up to the beginning of the current sorted section:
// If the current element (arr[j]) is larger than the element at max_idx (arr[max_idx]):
// Update max_idx to the current index j.
// Step 4: Swap Elements
// Swap the largest found element with the element at the current ending position of the unsorted section. This swap occurs only if the largest element is not already in the correct position (max_idx is not equal to the current index of the outer loop).
// Step 5: Move the Boundary
// Move the ending index of the unsorted section one position to the left by decrementing the index of the outer loop, effectively growing the sorted section.







// Performance:
// Time Complexity:
// Best, Average, and Worst Cases: 
// 𝑂
// (
// 𝑛
// 2
// )
// O(n 
// 2
//  ). The two nested loops mean that the algorithm still performs a similar number of comparisons regardless of the initial order of the array.
// Space Complexity:
// 𝑂
// (
// 1
// )
// O(1) as this algorithm is in-place, with no need for additional significant storage beyond temporary variables.