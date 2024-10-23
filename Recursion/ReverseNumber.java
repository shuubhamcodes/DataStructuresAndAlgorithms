package Recursion;

public class ReverseNumber {
    
    public static int reverse(int num, int rev){
        if(num==0){
            return rev;
        }

        rev = rev*10 + num%10;
        return reverse(num/10, rev);
    }



    public static int reverseNumber(int num){
        return reverse(num, 0);
    }

    public static void main(String[]args){
        int number = 12345;
        System.out.println(reverseNumber(number));
    }
}















// In recursive algorithms, it is often necessary to keep track of additional variables that are required to solve the problem, but which do not change directly in the recursive calls (or change in a controlled manner). To handle this, you may use a **helper function**. This pattern is especially useful when:

// 1. **You Need Extra State Information:** 
//    A recursive function may need more variables to maintain additional state between recursive calls. However, the recursive call might only naturally accept certain parameters, such as the main input to the problem. In such cases, a helper function is introduced to handle the extra parameters.

// 2. **Controlling State Initialization:** 
//    The extra variables might need to be initialized only once at the start of the process. Without a helper function, you would have to pass these extra variables at every recursion call, which can make the main logic less readable.

// 3. **Simplification of Function Signature:**
//    To keep the public function’s signature simple, you can hide the extra arguments by having the public function call the helper function internally. This makes the API of your function easier to understand and use without cluttering the interface with details.

// ### Why a Helper Function Is Important:

// 1. **Maintains Abstraction:**
//    - The main function can be kept simple for users, handling just the input values, while the helper function manages recursion with all necessary variables.
   
// 2. **Cleaner Code Structure:**
//    - It helps in maintaining a **separation of concerns**. The primary function defines the high-level structure, and the helper function deals with the recursive mechanics.

// 3. **Avoids Global Variables:**
//    - Instead of using global variables (which can lead to bugs), the helper function allows you to pass these variables through the recursive call chain safely.

// 4. **Initialization Control:**
//    - Some variables, like accumulators (used in problems like reversing a number), should be initialized just once before the recursion starts. The helper function allows you to properly initialize these variables.

// ### Example: Reversing a Number (with a helper function)

// Here’s how we can modify the reverse number example, explaining the importance of the helper function.

// #### Without a helper function:
// ```java
// public static int reverse(int num) {
//     return reverseHelper(num, 0);
// }

// private static int reverseHelper(int num, int rev) {
//     if (num == 0) {
//         return rev;
//     }
//     rev = rev * 10 + num % 10;
//     return reverseHelper(num / 10, rev);
// }
// ```

// #### Explanation:
// 1. **Primary Function (reverse):**
//    - The primary function `reverse(int num)` is the main public function. It doesn’t need to worry about tracking the reverse value initially, so it just calls the helper function.
   
// 2. **Helper Function (reverseHelper):**
//    - The helper function `reverseHelper(int num, int rev)` manages the recursive calls. It tracks both the number being reversed and the progressively built reversed number (`rev`).
//    - `rev` is initialized to 0 in the primary function and is updated in each recursive call. Without a helper function, the reverse function would have needed an additional parameter, cluttering the API.

// ### Why Helper Functions Are Important:

// 1. **Extra Variables Needed:**
//    The function `reverseHelper` takes an additional `rev` parameter. This is critical for keeping track of the reversed digits through the recursion. Without a helper function, this would require the user to supply two parameters (`num` and `rev`) every time the function is called, which can make the function call look less intuitive.

// 2. **Cleaner Interface:**
//    By using a helper function, the user doesn't need to worry about how `rev` is handled. They simply call `reverse(num)` and the helper takes care of the details. This makes the main function cleaner and easier to use.

// ### Key Benefits:
// - **Easier to Use:** The caller of the function doesn't need to know about the internal recursive state (`rev`).
// - **Separation of Concerns:** The helper function focuses on the recursive logic, while the main function focuses on handling the initial call.
// - **Initialization Control:** We can ensure that the initial state (e.g., `rev = 0`) is set correctly in the main function before recursion begins.

// In summary, helper functions are crucial when you need to maintain additional variables or state in a recursive algorithm. They allow you to create cleaner and more maintainable code, with a simpler interface for the user.

