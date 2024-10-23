package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // Find the middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the second half of the list
        ListNode newHead = reverse(slow);
        ListNode first = head;
        ListNode second = newHead;
        // Compare both halves
        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead);  // Restore the original list
                return false;
            }
            second = second.next;
            first = first.next;
        }
        reverse(newHead);  // Restore the original list
        return true;
    }

    // Recursive function to reverse a linked list
    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newhead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    public static void main(String[] args) {
        // Helper method to create a linked list from an array of values
        int[] values = {1, 2, 2, 1};  // Example list: change values to test different cases
        ListNode dummy = new ListNode(-1);  // Dummy node to simplify list creation
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        ListNode head = dummy.next;

        // Create an instance of Solution and test if it's a palindrome
        PalindromeLinkedList solution = new PalindromeLinkedList();
        boolean result = solution.isPalindrome(head);

        // Output the result
        System.out.println("Is the list a palindrome? " + result);
    }
}



























// Problem: Check if a Linked List is a Palindrome
// The goal of this code is to check if a singly linked list is a palindrome. A palindrome means that the elements read the same forward and backward.

// Steps Involved:
// Finding the Middle of the Linked List using slow and fast pointers.
// Reversing the Second Half of the linked list.
// Comparing the Two Halves to see if they are identical.
// Restoring the Original List by reversing the second half back to its original order (optional, but done here for good practice).
// Concepts and Code Breakdown:
// 1. ListNode Class (Given)
// java
// Copy code
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
// This class defines a node in a singly linked list. Each node contains an integer val and a reference next to the next node in the list.

// 2. Finding the Middle of the Linked List
// java
// Copy code
// ListNode slow = head;
// ListNode fast = head;
// while(fast != null && fast.next != null) {
//     slow = slow.next;
//     fast = fast.next.next;
// }
// Concept: Slow and Fast Pointer Technique

// The goal here is to find the middle of the linked list.
// We use two pointers:
// slow: Moves one step at a time (slow = slow.next).
// fast: Moves two steps at a time (fast = fast.next.next).
// The fast pointer reaches the end of the list twice as fast as the slow pointer, so when fast reaches the end, slow will be at the middle of the list.
// 3. Reversing the Second Half of the List
// java
// Copy code
// ListNode newHead = reverse(slow);
// Here, the second half of the list, starting from the slow pointer (the middle), is reversed. We use a helper function reverse() to achieve this.

// Why Reverse? By reversing the second half, we can directly compare it with the first half of the list to check if it forms a palindrome.

// 4. Reverse Function Explanation
// java
// Copy code
// static ListNode reverse(ListNode head) {
//     if(head == null || head.next == null) {
//         return head;
//     }
//     ListNode newhead = reverse(head.next);
//     head.next.next = head;
//     head.next = null;
//     return newhead;
// }
// This function reverses a linked list using recursion.

// Base Case: If head is null or it is the last node (head.next == null), return head. This indicates we’ve reached the end of the list.
// Recursive Case:
// The recursive call moves towards the end of the list (reverse(head.next)).
// After reaching the last node, the function starts reversing the pointers (head.next.next = head) and disconnects the current node (head.next = null).
// This results in a reversed linked list.
// This method works by reversing the links between the nodes in a recursive manner.

// 5. Comparing the Two Halves
// java
// Copy code
// ListNode first = head;
// ListNode second = newHead;
// while(second != null) {
//     if(first.val != second.val) {
//         reverse(newHead);
//         return false;
//     }
//     first = first.next;
//     second = second.next;
// }
// After reversing the second half of the list, we now compare the values of the nodes in the first half (first) with the nodes in the reversed second half (second).
// If any pair of values doesn’t match, the list is not a palindrome, and we return false.
// 6. Restoring the Original List
// java
// Copy code
// reverse(newHead);
// After comparison, the second half of the list is reversed again to restore the list to its original form. This step is optional, but it's a good practice to maintain the original structure of the input data.
// 7. Return the Result
// java
// Copy code
// return true;
// If all values match during the comparison, the list is a palindrome, so the function returns true.
// Key Concepts Summarized:
// Slow and Fast Pointer Technique:

// Used to find the middle of the linked list in one pass, which ensures an efficient time complexity of O(n).
// Recursive Linked List Reversal:

// A classic linked list problem where we reverse the links between nodes. This is useful for many linked list operations.
// The recursive function provides an elegant and intuitive way to reverse the list.
// Palindromic Check:

// The problem is tackled by dividing the list in half, reversing one half, and then comparing both halves.
// After comparison, we restore the original list by reversing the second half again, maintaining good code hygiene.
// Time Complexity:

// Finding the middle: O(n)
// Reversing half the list: O(n/2)
// Comparing two halves: O(n/2)
// Total Time Complexity: O(n)
// Space Complexity:

// The space complexity is O(1) because we are using a constant amount of extra space (ignoring the recursive stack in the reverse() function, which could be O(n) in the worst case).
// To reduce the space complexity to strictly O(1), you can use an iterative approach for reversing.
// Edge Cases to Consider:
// Single node or empty list: These are palindromes by definition.
// Lists with an odd number of elements: The middle element is skipped and doesn't affect the result.
// Very large lists: Ensure that the recursive reverse function doesn’t cause a stack overflow. In interview scenarios, you might want to switch to an iterative reversal to avoid this.
// Potential Interview Questions:
// How can you optimize the space complexity in this problem?

// You can optimize space by using an iterative approach to reverse the linked list, as recursion uses extra stack space.
// How does the slow and fast pointer technique help in finding the middle of the list?

// The fast pointer moves twice as fast as the slow pointer, so when the fast pointer reaches the end, the slow pointer is at the middle of the list.
// What happens when the linked list has an odd number of nodes?

// The middle node is ignored when comparing the two halves. For example, in a list with elements [1, 2, 3, 2, 1], the middle 3 is not compared to anything.