

```java
public class Main {

    public static void main(String[] args) {
        // Starting point: call the first function
        print_num(1);
    }

    static void print_num(int n) {
        // Prints the number passed as argument
        System.out.println(n);
        // Calls the next function in sequence
        print_num_2(2);
    }

    static void print_num_2(int n) {
        // Prints the number passed as argument
        System.out.println(n);
        // Calls the next function in sequence
        print_num_3(3);
    }

    static void print_num_3(int n) {
        // Prints the number passed as argument
        System.out.println(n);
    }
}
```

### Expected Output:
```
1
2
3
```

### Explanation:
- **`main` function**: The execution starts here, and it calls the `print_num(1)` function.
- **`print_num(1)`**: This function prints `1` and then calls `print_num_2(2)`.
- **`print_num_2(2)`**: This function prints `2` and then calls `print_num_3(3)`.
- **`print_num_3(3)`**: This function prints `3`, and since there are no more function calls, it completes.

Each function is placed on the call stack as it is called, and once a function completes, it is removed from the stack, handing control back to the function that called it. This mirrors the behavior visualized in the diagram you provided.

















### 1. **Overview of the Code:**
The program consists of a `Main` class with a `main` method that calls several other methods. Here's a breakdown:

- `main` calls `print_num(1)`.
- `print_num(1)` prints `1` and then calls `print_num_2(2)`.
- `print_num_2(2)` prints `2` and calls `print_num_3(3)`.
- `print_num_3(3)` simply prints `3`.

#### Output:
- The program will print `1`, `2`, and `3` sequentially, but the magic happens in how the function calls are managed in memory, which is where the call stack comes into play.

### 2. **The Call Stack Explained:**

The **call stack** is a special type of data structure used to manage function calls. Whenever a function is called, it's added (or "pushed") onto the stack, and when it finishes executing, it is removed (or "popped") from the stack.

Let's break this down in detail:

#### **Step 1:** 
- The `main` function is the first to be pushed onto the stack. 
- Since `main` is not finished executing (it still needs to call `print_num(1)`), it stays on the stack.
- Next, the `print_num(1)` function is called. This function is added to the stack **above** `main`.

#### **Step 2:**
- While `print_num(1)` is executing, it prints `1` and then calls `print_num_2(2)`.
- At this point, `print_num_1` has not finished executing, so it remains on the stack.
- Now, `print_num_2(2)` is added to the stack, **above** `print_num(1)` and `main`.

#### **Step 3:**
- `print_num_2(2)` prints `2` and then calls `print_num_3(3)`.
- Similarly, `print_num_2(2)` remains on the stack, and `print_num_3(3)` is pushed onto the stack **above** it.

#### **Step 4:**
- `print_num_3(3)` prints `3` and completes its execution.
- After finishing, it is **popped** from the stack, and control returns to `print_num_2(2)`.

#### **Step 5:**
- Now that `print_num_2(2)` knows that `print_num_3(3)` is done, it finishes its execution and is popped from the stack.
- Control goes back to `print_num(1)`.

#### **Step 6:**
- `print_num(1)` is now done, and it is also popped from the stack.
- Control returns to `main`.

#### **Step 7:**
- Finally, when `main` has no more function calls to make, it finishes execution and is popped from the stack, marking the end of the program.

### 3. **Stack Behavior in Function Calls:**

- **"LIFO" (Last In, First Out)**: The stack operates in a LIFO manner. The last function that is pushed onto the stack is the first one to be popped off when it finishes execution. 
- **Each function call waits**: Until a called function completes, the calling function stays in the stack. For example, `main` waits until `print_num(1)` finishes, and `print_num(1)` waits until `print_num_2(2)` finishes, and so on.
  
This process ensures that the program execution flows smoothly, and it prevents functions from being removed prematurely from memory before their work is done.

### 4. **Program Flow Transitions (Control Flow):**
- At every step, once a function finishes, control is transferred back to the calling function, and the function is removed from the stack.
- The stack ensures that after a function completes, the program can "resume" exactly where it left off.

### Summary of Key Concepts:
- **Call Stack**: A memory structure that holds information about active function calls.
- **Function Execution**: Functions remain on the stack until they complete.
- **Stack Memory**: Each function is stacked on top of the previous one, and once it finishes, it is removed in reverse order of the calls.
- **Flow of Program**: Control is transferred from one function to another, and when a function completes, the previous function resumes execution.

In essence, this image effectively visualizes the behavior of function calls in terms of how they are stored and removed from the stack.















Here's the Java code based on the diagram you shared that illustrates how function calls work using a simple example of recursive or nested function calls:

```java
public class Main {

    public static void main(String[] args) {
        // Starting point: call the first function
        print_num(1);
    }

    static void print_num(int n) {
        // Prints the number passed as argument
        System.out.println(n);
        // Calls the next function in sequence
        print_num_2(2);
    }

    static void print_num_2(int n) {
        // Prints the number passed as argument
        System.out.println(n);
        // Calls the next function in sequence
        print_num_3(3);
    }

    static void print_num_3(int n) {
        // Prints the number passed as argument
        System.out.println(n);
    }
}
```

### Expected Output:
```
1
2
3
```

### Explanation:
- **`main` function**: The execution starts here, and it calls the `print_num(1)` function.
- **`print_num(1)`**: This function prints `1` and then calls `print_num_2(2)`.
- **`print_num_2(2)`**: This function prints `2` and then calls `print_num_3(3)`.
- **`print_num_3(3)`**: This function prints `3`, and since there are no more function calls, it completes.

Each function is placed on the call stack as it is called, and once a function completes, it is removed from the stack, handing control back to the function that called it. This mirrors the behavior visualized in the diagram you provided.















---

### **1. Implementing the Example Using Recursion**

In the previous example, we had separate functions calling each other in sequence. We can achieve the same behavior using a single recursive function. Here's how you can modify the code:

```java
public class Main {

    public static void main(String[] args) {
        // Start the recursive function with n = 1
        print_num(1);
    }

    static void print_num(int n) {
        // Base case: stop recursion when n exceeds 3
        if (n > 3) {
            return;
        }
        // Print the current number
        System.out.println(n);
        // Recursive call with incremented value
        print_num(n + 1);
    }
}
```

#### **Explanation:**

- **`main` Function:**
  - Initiates the recursive process by calling `print_num(1)`.

- **`print_num(int n)` Function:**
  - **Base Case:** If `n` exceeds `3`, the function returns, ending the recursion.
  - **Recursive Case:**
    - Prints the current value of `n`.
    - Calls itself with `n + 1`.

#### **Expected Output:**

```
1
2
3
```

---

### **2. Understanding Recursion and the Call Stack**

In recursion, a function calls itself to solve smaller instances of the same problem. Each recursive call adds a new layer to the call stack, just like individual function calls.

#### **Call Stack Behavior in Recursion:**

1. **First Call:** `print_num(1)`
   - Prints `1`.
   - Calls `print_num(2)`.
   - **Stack:** `print_num(1)`

2. **Second Call:** `print_num(2)`
   - Prints `2`.
   - Calls `print_num(3)`.
   - **Stack:** `print_num(2)` on top of `print_num(1)`

3. **Third Call:** `print_num(3)`
   - Prints `3`.
   - Calls `print_num(4)`.
   - **Stack:** `print_num(3)` on top of `print_num(2)`

4. **Fourth Call (Base Case):** `print_num(4)`
   - `n` is `4`, which is greater than `3`.
   - Function returns without making further calls.
   - **Stack:** `print_num(4)` is popped off

5. **Unwinding the Stack:**
   - Each function call completes and is popped off the stack in reverse order:
     - `print_num(3)` completes.
     - `print_num(2)` completes.
     - `print_num(1)` completes.

---

### **3. Creating and Analyzing the Recursion Tree**

A **recursion tree** is a visual representation of the function calls in a recursive algorithm. It helps in understanding how the recursive calls are made and how they return.

#### **Recursion Tree for `print_num(n)`**

```
print_num(1)
   |
   --> print_num(2)
          |
          --> print_num(3)
                 |
                 --> print_num(4) [Base case reached, returns]
```

- **Nodes:** Each node represents a function call with a specific value of `n`.
- **Edges:** The arrows show the flow from one recursive call to the next.
- **Leaves:** The base case where the recursion ends.

#### **Analyzing the Tree:**

- **Depth:** The depth of the tree corresponds to the number of recursive calls.
- **Base Case:** The leaf node where `n > 3` stops further recursion.
- **Execution Flow:**
  - The function calls are made from top to bottom (going deeper into recursion).
  - The function returns happen from bottom to top (unwinding the stack).

---

### **4. Connecting Function Calls, Recursion, and the Call Stack**

#### **Similarities:**

- **Call Stack Usage:**
  - Both regular function calls and recursive calls use the call stack to keep track of active functions.
- **Order of Execution:**
  - Functions are executed in a **LIFO** (Last In, First Out) manner.
- **Function Activation Records:**
  - Each call creates an activation record (or stack frame) on the call stack, storing parameters, local variables, and return addresses.

#### **Differences:**

- **Function Calls:**
  - In the original example, different functions (`print_num`, `print_num_2`, `print_num_3`) called each other.
- **Recursion:**
  - In the recursive example, the same function (`print_num`) calls itself with different arguments.

---

### **5. Steps to Create and Analyze a Recursion Tree**

1. **Identify the Recursive Function:**
   - Determine the function that calls itself and understand the parameters.

2. **Determine the Base Case:**
   - Find out where the recursion stops to prevent infinite loops.

3. **Draw the Initial Call:**
   - Start with the initial function call (e.g., `print_num(1)`).

4. **Expand the Tree:**
   - For each recursive call, draw a child node with the new function call.
   - Continue expanding until the base case is reached.

5. **Annotate the Tree:**
   - Label each node with the function's parameter values.
   - Optionally, note the return values if applicable.

6. **Analyze the Tree:**
   - Look at the depth to understand the maximum call stack size.
   - Identify redundant calculations (useful for optimizing recursive algorithms).

---

### **6. Practical Tips for Recursion and Call Stack Management**

- **Avoid Stack Overflow:**
  - Ensure that your base case is reachable to prevent infinite recursion.
- **Use Recursion Judiciously:**
  - Recursion can be elegant but may not be the most efficient approach for all problems.
- **Understand Tail Recursion:**
  - Tail-recursive functions can be optimized by some compilers to prevent additional stack usage.
- **Visualize with Recursion Trees:**
  - Drawing recursion trees can help in understanding and debugging recursive algorithms.

---

### **Summary**

- **Recursion** allows a function to call itself with modified parameters to solve smaller instances of a problem.
- The **call stack** plays a crucial role in managing recursive calls, just as it does with regular function calls.
- A **recursion tree** visually represents the flow of recursive calls and is a valuable tool for analyzing and understanding recursive algorithms.
- By connecting the concepts of function calls, recursion, and the call stack, we gain a deeper understanding of how programs execute and manage memory during runtime.

---

By transforming the sequential function calls into a recursive function, we've demonstrated how recursion utilizes the call stack similarly but often more efficiently for certain problems. Understanding these concepts is fundamental in computer science, especially in algorithms and system design.








