package SlidingWindowProblems;

class Solution {
    // Brute-force approach
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = Double.NEGATIVE_INFINITY; // Initialize with the lowest possible double value
        
        for (int i = 0; i <= nums.length - k; i++) {
            int j = i;
            int y = 0;
            int sum = 0;
            
            // Calculate the sum of the subarray of size k
            while (y < k) {
                sum += nums[j];
                j++;
                y++;
            }
            
            // Calculate the average as a double and update maxAverage if needed
            double average = (double) sum / k;
            if (average > maxAverage) {
                maxAverage = average;
            }
        }
        
        return maxAverage;
    }

    // Sliding window approach
    public double findMaxAverageUsingSlidingWindow(int[] nums, int k) {
        int windowSum = 0;
        // Calculate the sum of the first window of size `k`
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        
        double maxAverage = (double) windowSum / k;

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            // Subtract the element going out of the window and add the element coming in
            windowSum = windowSum - nums[i - k] + nums[i];

            // Update maxAverage if the new average is higher
            maxAverage = Math.max(maxAverage, (double) windowSum / k);
        }
        
        return maxAverage;
    }

    // Main function to test both methods
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        // Testing brute-force method
        double resultBruteForce = solution.findMaxAverage(nums, k);
        System.out.println("Maximum Average (Brute-Force): " + resultBruteForce);

        // Testing sliding window method
        double resultSlidingWindow = solution.findMaxAverageUsingSlidingWindow(nums, k);
        System.out.println("Maximum Average (Sliding Window): " + resultSlidingWindow);
    }
}
