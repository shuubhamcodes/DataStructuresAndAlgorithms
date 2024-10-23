
package LinkedList;

public class LinkedListCycle2leetcode {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Cycle entry point
            }
        }
        return null; // No cycle
    }

    public static void main(String[] args) {
        // Creating a linked list with a cycle for testing: 3 -> 2 -> 0 -> -4 -> 2 (cycle)
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating a cycle here

        LinkedListCycle2leetcode solution = new LinkedListCycle2leetcode();
        ListNode cycleStart = solution.detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}



















// ```java
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
// ```
// 1. **Class Declaration**: This declares a public class named `Solution`. This class is expected to contain methods for solving the problem.
   
// 2. **Method Declaration**: The method `detectCycle` is declared, which takes a `ListNode` called `head` as an argument and returns a `ListNode`. This method is responsible for detecting the start of a cycle in the linked list.

// ```java
//         if (head == null || head.next == null){
//             return null;
//         }
// ```
// 3. **Base Case Check**: This line checks if the `head` of the linked list is `null` or if there is only one node in the list (`head.next` is `null`). If either condition is true, the method returns `null` since a cycle cannot exist in an empty list or a list with a single node. This is a crucial early exit to prevent unnecessary processing.

// ```java
//         ListNode slow = head;
//         ListNode fast = head;
// ```
// 4. **Pointer Initialization**: Two pointers are initialized:
//    - `slow` is set to the `head` of the list and will move one step at a time.
//    - `fast` is also set to the `head` and will move two steps at a time. This setup is part of Floyd's Tortoise and Hare algorithm, which uses two pointers to detect cycles efficiently.

// ```java
//         while(fast != null && fast.next != null){
// ```
// 5. **Cycle Detection Loop**: This `while` loop will continue as long as `fast` is not `null` and `fast.next` is not `null`. This ensures that both pointers can safely move without hitting a null reference.

// ```java
//             fast = fast.next.next;
//             slow = slow.next;
// ```
// 6. **Pointer Movement**: Within the loop:
//    - The `fast` pointer moves two nodes forward (`fast = fast.next.next`).
//    - The `slow` pointer moves one node forward (`slow = slow.next`).
//    This means that if there is a cycle, eventually, `slow` and `fast` will meet inside the cycle.

// ```java
//             if(fast == slow){
// ```
// 7. **Cycle Detected**: If `fast` meets `slow`, it indicates that a cycle is present in the linked list. This is the intersection point inside the cycle.

// ```java
//                 slow = head;
// ```
// 8. **Resetting Slow Pointer**: Once a cycle is detected, the `slow` pointer is reset to the head of the linked list. This is important because we will now move both `slow` and `fast` at the same speed to find the entry point of the cycle.

// ```java
//                 while(slow != fast){
// ```
// 9. **Finding the Entry Point**: This `while` loop continues until `slow` and `fast` meet again. The idea is that if both pointers move at the same speed, they will meet at the entry point of the cycle.

// ```java
//                     slow = slow.next;
//                     fast = fast.next;
// ```
// 10. **Moving to Find Entry**: Within this loop:
//     - Both `slow` and `fast` move one step forward.
//     - Since `slow` starts from the head and `fast` is at the meeting point, they will meet at the entry point of the cycle.

// ```java
//                 }
//                 return slow;
// ```
// 11. **Return Cycle Entry**: When `slow` meets `fast`, the loop ends, and `slow` (or `fast`) is returned. This node is the start of the cycle.

// ```java
//             }
// ```
// 12. **End of Cycle Detection**: This bracket marks the end of the `if (fast == slow)` block.

// ```java
//         }
//         return null;
//     }
// }
// ```
// 13. **No Cycle Detected**: If the loop finishes and `fast` never meets `slow`, it means there is no cycle in the linked list, and the method returns `null`.

// ### Key Concepts Involved:
// - **Floyd's Cycle Detection Algorithm**: This algorithm is efficient for cycle detection in linked lists using two pointers (slow and fast). It runs in O(n) time and uses O(1) space.
// - **Pointers**: Understanding how pointers can be manipulated to traverse the linked list is crucial.
// - **Linked List Structure**: Familiarity with the linked list data structure, especially how nodes are linked, is necessary for this solution.

// ### Conclusion
// This method efficiently detects the cycle and finds its starting point with minimal overhead, making it a classic approach in algorithm interviews. The use of two pointers with different speeds is a clever way to exploit the structure of linked lists, ensuring optimal performance.

// For further reading, consider checking out:
// - [GeeksforGeeks on Cycle Detection in Linked Lists](https://www.geeksforgeeks.org/detecting-cycle-in-a-linked-list/)
// - [LeetCode Problem on Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)