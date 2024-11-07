package SlidingWindowProblems;

public class LargestSubarrayOfLengthK {
    // Brute-force approach
    public int[] findLargestSubarrayBruteForce(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;

        for (int i = 0; i <= nums.length - k; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += nums[j];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = i;
            }
        }

        int[] result = new int[k];
        System.arraycopy(nums, startIndex, result, 0, k);
        return result;
    }

    // Sliding window approach
    public int[] findLargestSubarraySlidingWindow(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            
            if (windowSum > maxSum) {
                maxSum = windowSum;
                startIndex = i - k + 1;
            }
        }

        int[] result = new int[k];
        System.arraycopy(nums, startIndex, result, 0, k);
        return result;
    }

    public static void main(String[] args) {
        LargestSubarrayOfLengthK solution = new LargestSubarrayOfLengthK();
        
        int[] nums = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        // Test Brute-Force Solution
        int[] largestSubarrayBruteForce = solution.findLargestSubarrayBruteForce(nums, k);
        System.out.println("Largest Subarray (Brute Force): ");
        for (int num : largestSubarrayBruteForce) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test Sliding Window Solution
        int[] largestSubarraySlidingWindow = solution.findLargestSubarraySlidingWindow(nums, k);
        System.out.println("Largest Subarray (Sliding Window): ");
        for (int num : largestSubarraySlidingWindow) {
            System.out.print(num + " ");
        }
    }
}
