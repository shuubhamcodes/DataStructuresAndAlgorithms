### **Two Pointers Pattern in Java**

The **Two Pointers** pattern is used to solve problems where we need to process a pair or set of elements in an array or a sequence based on some conditions. The key idea is to use two pointers that move in different directions (often towards each other) and help reduce the time complexity of brute-force solutions. The pattern is commonly used when the input array is sorted or partially ordered, as it allows the efficient processing of elements.

#### **Core Concept**

- **Fixed Start/End Pointers**: In this approach, one pointer starts at the beginning and the other at the end of the array. We then move the pointers towards each other depending on the conditions (e.g., sum greater than or less than a target value).
  
- **Multiple Iterations**: Sometimes, we use nested loops where the outer loop processes one element, and the inner loop moves the two pointers inwards to find a pair/triplet that satisfies a condition.

#### **Key Advantages**

- **Optimized Time Complexity**: By leveraging the sorted nature of the array or sequence, the Two Pointers approach often reduces the time complexity from O(N²) to O(N) or O(N log N).
  
- **Space Efficiency**: The pattern generally runs in constant space (O(1)).

### **1. Pair with Target Sum (Two Sum - Easy)**

**Problem**: Given a sorted array, find the indices of two numbers that add up to a given target sum.

**Approach**: Use two pointers, one at the beginning and one at the end of the array. Move the pointers inward based on whether the sum is less than or greater than the target.

```java
public class TwoSum {
    public static int[] pairWithTargetSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[] { left, right };
            }
            if (sum < target) {
                left++; // need a pair with a larger sum
            } else {
                right--; // need a pair with a smaller sum
            }
        }
        return new int[] { -1, -1 }; // no pair found
    }

    public static void main(String[] args) {
        int[] result = pairWithTargetSum(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println(result[0] + " " + result[1]); // Output: 1 3
    }
}
```

### **2. Remove Duplicates from Sorted Array (Easy)**

**Problem**: Remove duplicates in a sorted array in-place and return the new length of the array after removal.

**Approach**: Use two pointers, one to iterate through the array, and one to track the position of the next non-duplicate element.

```java
public class RemoveDuplicates {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(removeDuplicates(arr)); // Output: 4
    }
}
```

### **3. Triplet Sum to Zero (Medium)**

**Problem**: Find all unique triplets in an array that add up to zero.

**Approach**: Sort the array and use two pointers to find pairs that sum to the negative of the current number.

```java
import java.util.*;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) // skip the same element to avoid duplicates
                continue;
            searchPair(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) left++; // skip duplicates
                while (left < right && arr[right] == arr[right + 1]) right--; // skip duplicates
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 })); // Output: [[-3, 1, 2], [-2, -1, 1], [-2, 0, 2]]
    }
}
```

### **4. Triplet Sum Close to Target (Medium)**

**Problem**: Find the triplet in an array whose sum is closest to a given target.

**Approach**: Sort the array and use two pointers to search for the closest sum.

```java
public class TripletSumCloseToTarget {
    public static int tripletSumCloseToTarget(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) { // exact match
                    return targetSum;
                }
                if (Math.abs(targetDiff) < Math.abs(smallestDiff) || (Math.abs(targetDiff) == Math.abs(smallestDiff) && targetDiff > smallestDiff)) {
                    smallestDiff = targetDiff; // update the smallest diff
                }
                if (targetDiff > 0) {
                    left++; // need a bigger sum
                } else {
                    right--; // need a smaller sum
                }
            }
        }
        return targetSum - smallestDiff;
    }

    public static void main(String[] args) {
        System.out.println(tripletSumCloseToTarget(new int[] { -2, 0, 1, 2 }, 2)); // Output: 1
    }
}
```

### **5. Triplets with Smaller Sum (Medium)**

**Problem**: Count all triplets in the array such that their sum is less than the target.

**Approach**: Sort the array and use two pointers to find triplets whose sum is less than the target.

```java
public class TripletWithSmallerSum {
    public static int tripletWithSmallerSum(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                count += right - left; // since arr[right] >= arr[left], all pairs from left to right will have a sum < target
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(tripletWithSmallerSum(new int[] { -1, 0, 2, 3 }, 3)); // Output: 2
    }
}
```

### **6. Subarrays with Product Less than a Target (Medium)**

**Problem**: Find all contiguous subarrays whose product is less than a given target.

**Approach**: Use a sliding window approach with two pointers.

```java
import java.util.*;

public class SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int product = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left < arr.length) {
                product /= arr[left];
                left++;
            }
            List<Integer> tempList = new ArrayList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr

[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[] { 2, 5, 3, 10 }, 30)); // Output: [[2], [5], [2, 5], [3], [5, 3], [10]]
    }
}
```

### **7. Dutch National Flag Problem (Sort Colors - Medium)**

**Problem**: Given an array containing 0s, 1s, and 2s, sort the array in-place.

**Approach**: Use two pointers (`low` and `high`) to partition the array into three sections.

```java
public class DutchNationalFlag {
    public static void sortColors(int[] arr) {
        int low = 0, high = arr.length - 1;
        int i = 0;
        while (i <= high) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        sortColors(arr);
        System.out.println(Arrays.toString(arr)); // Output: [0, 0, 1, 1, 2]
    }
}
```

### **8. Comparing Strings containing Backspaces (Medium)**

**Problem**: Compare two strings that may contain backspaces (`#`), and check if they are equal.

**Approach**: Use two pointers to traverse both strings from the end to the beginning.

```java
public class BackspaceCompare {
    public static boolean backspaceCompare(String str1, String str2) {
        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int i1 = getNextValidCharIndex(str1, index1);
            int i2 = getNextValidCharIndex(str2, index2);
            if (i1 < 0 && i2 < 0) { // reached the end of both strings
                return true;
            }
            if (i1 < 0 || i2 < 0 || str1.charAt(i1) != str2.charAt(i2)) {
                return false;
            }
            index1 = i1 - 1;
            index2 = i2 - 1;
        }
        return true;
    }

    private static int getNextValidCharIndex(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("xy#z", "xzz#")); // Output: true
    }
}
```

### **Categorized Problems Under the Two Pointers Pattern**

1. **Basic Two Pointer Problems**:
   - Pair with Target Sum
   - Remove Duplicates from Sorted Array
   - Remove Element

2. **Two Pointer + Sorting**:
   - Triplet Sum to Zero
   - Triplet Sum Close to Target
   - Triplet with Smaller Sum
   - Quadruple Sum to Target

3. **Two Pointer + Sliding Window**:
   - Subarrays with Product Less than a Target
   - Comparing Strings containing Backspaces

4. **Dutch National Flag**:
   - Sorting arrays in-place with three unique elements

This pattern is highly effective for problems involving pairs, triplets, or sets of elements that meet certain criteria, and these categorized questions showcase its power and efficiency.