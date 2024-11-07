package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int m = matrix.length;    // number of rows
        int n = matrix[0].length; // number of columns
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // Traverse from right to left along the bottom boundary
            if (top <= bottom) { // Check if there is still a bottom row
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            // Traverse from bottom to top along the left boundary
            if (left <= right) { // Check if there is still a left column
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }
        
        return list;
    }
    
    // Main method to test and print the spiral order
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println(result);
    }
}
