The **Sliding Window pattern** is a useful technique for solving problems that involve arrays, strings, or other data structures where you're asked to find something related to contiguous subarrays or substrings of a given size. The pattern works by maintaining a window that slides over the input, performing efficient updates to track the necessary information, and avoiding redundant calculations. Below are the core concepts and several example problems categorized under this pattern, with solutions in **Java**.

---

### **Sliding Window Pattern Concepts**

1. **Fixed-sized Window**: Problems where the size of the window is predetermined.
   - Example: Finding the maximum sum of a subarray of size `k`.
   - Approach: Slide a window of size `k` through the array by adding the new element coming into the window and subtracting the one going out.
   - Time Complexity: O(N), since each element is added and removed once.

2. **Dynamic-sized Window**: Problems where the window size is determined dynamically based on conditions like the sum of elements or distinct characters.
   - Example: Finding the smallest subarray with a sum greater than `S`.
   - Approach: Expand the window to meet the condition, and then contract it to minimize the size or find the optimal solution.
   - Time Complexity: O(N), since each element is processed at most twice.

3. **HashMap or Frequency Counter**: Sliding window problems often involve keeping track of frequencies of elements (e.g., characters in a string).
   - Example: Finding the longest substring with at most `K` distinct characters.
   - Approach: Use a `HashMap` to store the frequencies of characters, and adjust the window size based on the conditions.
   - Time Complexity: O(N), where N is the length of the input string or array.

---

### **Fixed-Sized Window Problems**

#### **1. Maximum Sum Subarray of Size K (Easy)**

**Problem**: Given an array of positive numbers and a number `K`, find the maximum sum of any contiguous subarray of size `K`.

```java
public class MaxSumSubarrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0, windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2})); // Output: 9
        System.out.println(findMaxSumSubArray(2, new int[] {2, 3, 4, 1, 5})); // Output: 7
    }
}
```

---

#### **2. Find Averages of Subarrays of Size K (Easy)**

**Problem**: Given an array, find the average of all contiguous subarrays of size `K`.

```java
public class AverageOfSubarrays {
    public static double[] findAverages(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window
            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k; // calculate the average
                windowSum -= arr[windowStart]; // remove the element going out of the window
                windowStart++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[] result = findAverages(5, new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2});
        for (double avg : result) {
            System.out.print(avg + " "); // Output: [2.2, 2.8, 2.4, 3.6, 2.8]
        }
    }
}
```

---

### **Dynamic-Sized Window Problems**

#### **3. Smallest Subarray with a Given Sum (Medium)**

**Problem**: Given an array of positive numbers and a positive number `S`, find the length of the smallest contiguous subarray whose sum is greater than or equal to `S`.

```java
public class SmallestSubarrayWithGivenSum {
    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // shrink the window
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2})); // Output: 2
        System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 8})); // Output: 1
    }
}
```

---

### **String Sliding Window Problems**

#### **4. Longest Substring with at Most K Distinct Characters (Medium)**

**Problem**: Given a string, find the length of the longest substring that contains at most `K` distinct characters.

```java
import java.util.HashMap;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2)); // Output: 4
        System.out.println(findLength("araaci", 1)); // Output: 2
    }
}
```

---

#### **5. Longest Substring without Repeating Characters (Hard)**

**Problem**: Given a string, find the length of the longest substring which has no repeating characters.

```java
import java.util.HashMap;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charIndexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb")); // Output: 3
        System.out.println(findLength("abbbb")); // Output: 2
    }
}
```

---

#### **6. Permutation in a String (Hard)**

**Problem**: Given a string and a pattern, find out if the string contains any permutation of the pattern.

```java
import java.util.HashMap;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        int windowStart = 0, matched = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == charFrequencyMap.size()) {
                return true;
            }

            if (windowEnd >= pattern.length() -

 1) {
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("oidbcaf", "abc")); // Output: true
        System.out.println(findPermutation("odicf", "dc")); // Output: false
    }
}
```

---

### **Key Problems Categorized under Sliding Window**

- **Fixed-Sized Window**:
  - Find Averages of Subarrays of Size K
  - Maximum Sum Subarray of Size K
  
- **Dynamic-Sized Window**:
  - Smallest Subarray with a Given Sum
  - Longest Substring with K Distinct Characters
  
- **String Problems**:
  - Longest Substring without Repeating Characters
  - Permutation in a String
  - Longest Substring with at Most Two Distinct Characters
  - Words Concatenation
  - Smallest Window containing Substring

---

By practicing these problems, you can master the **Sliding Window pattern** in Java and understand how to apply it efficiently to various coding problems.