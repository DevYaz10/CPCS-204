// StackArrayDemo.java
// Author:
// Program to test the stack (array version)
// Used for Lab on Stacks

package stackarraydemo;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StackArrayDemo {

	public static void main(String[] args) {
		// Make Scanner
		Scanner input = new Scanner(System.in);
		
		// Other variables
		int choice; // user choice
		int value;  // value to insert, delete, or search for
		String postfix, infix;
		StackArray postfixStack; // used for evaluating postfix
		StackArray infixStack; // used for converting infix to postfix
		
		// Make a new array-based stack
        StackArray myStack = new StackArray(5);
		
		// Do/while loop showing menu, getting user choice, and performing actions
		do {
			// Show menu and get user choice
			showMenu();
			choice = input.nextInt();
			
			// PUSH new value into stack
			if (choice == 1) {
				if (!myStack.isFull()) {
					System.out.print(">    What value do you want to push: ");
					value = input.nextInt();

					// Invoke push method with "value" as the parameter
					myStack.push(value);
					System.out.println(">    " + value + " was successfully pushed into the stack.");
					System.out.println();
				}
				else {
					System.out.println(">    ERROR: cannot push (stack is full).");
					System.out.println();
				}
			}
			
			// POP value from stack
			else if (choice == 2) {				
				// First, check to see if stack is empty.
				// IF it is, then we clearly cannot POP
				if (myStack.isEmpty()) {
					System.out.println(">    Error: cannot pop stack (stack is empty).");
				}
				// ELSE, POP the stack. The pop() method returns an int. (the value at top of stack)
				// You can do whatever you want with this reference. Here, we simply print the Data value,
				// indicating that it has been popped from the stack.
				else {
					int temp = myStack.pop();
					System.out.println(">    " + temp + " has been popped from the stack.");
				}
				System.out.println();
			}
			
			// PEEK (look at) the top value of the stack...but do not actually pop it off
			else if (choice == 3) {
				// First, check to see if stack is empty.
				// IF it is, then we clearly cannot PEEK
				if (myStack.isEmpty()) {
					System.out.println(">    Error: cannot peek at stack (stack is empty).");
				}
				// ELSE, we invoke the peek() method, which returns an int value, representing
				// the value at the top of the stack. If you prefer, you could have the peek() method
				// return a reference to the actual top node. (if this was a stack of objects). 
				// This gives you more flexibility to print a variety of data members, modify the node, etc.
				else {
					System.out.println(">    " + myStack.peek() + " is the value at the top of the stack.");
				}
				System.out.println();
			}
			
			// Search for an item in the stack
			else if (choice == 4) {
				System.out.print(">    What value do you want to search for: ");
				value = input.nextInt();
				if (myStack.search(value))
					System.out.println(">    " + value + " was found in the stack.");
				else
					System.out.println(">    " + value + " was not found in the stack.");
				System.out.println();
			}
			
			// Print all values in stack
			else if (choice == 5) {
				if (myStack.isEmpty()) {
					System.out.println(">    Error: cannot print nodes (the stack is empty)");
					System.out.println();
				}
				else {
					System.out.println(">    Printing All Nodes:");
					System.out.print(">    ");
					myStack.PrintStack();
					System.out.println();
					System.out.println();
				}
			}
			
			// ******************************************************************* //
			//                          LAB ACTIVITY #1                            //
			// ******************************************************************* //
			else if (choice == 6) {
				// Don't worry about the line below...we use it to advance the carriage return
				input.nextLine();
				// Make a new array-based stack
				postfixStack = new StackArray(10);
				System.out.println("Enter the Postfix expression you wish to evaluate (type on one line and use spaces between all terms): ");
				System.out.println("     Example: 7 16 * 5 + 16 * 3 + 16 * 1 +");
				System.out.print("     Please enter the postfix expression:  ");
				
				// READ the entire postfix expression (with spaces) into the String variable postfix.
				// NOTE: we assume the expression is a LEGAL postfix expression.
				//       So no need to check if illegal.
				postfix = input.nextLine();
				int number1;
                                int number2;
                                int result = 0;
                                
                                ///////////////////////////////////////////
                                


                                
                                ///////////////////////////////////////////
				// The following FOR loop is used to extract each token, examine it, and then perform some action.
				// Here, just so you understand, we print out each token.
				// Hopefully, it is clear what is going on.
				//    - The .split() method takes a string (postfix) and will "split" it up into the different parts.
				//    - How does it "split" up the string? It does so based on the delimiter, which, in this case, is a space.
				// So on this example, we split the postfix expression based on spaces, and we print each "token"
				for (String token: postfix.split(" ")) {
				//	System.out.println(token); // DELETE this print statement after you understand what is going on
					
					// LAB ACTIVITY #1
					// PUT CODE HERE
					// You must write code to check the value of each token
					// If it is an operand (a number), you PUSH it into the stack
                                        if (!"+".equals(token) && !"*".equals(token) && !"-".equals(token) && !"/".equals(token)) {
                                            //Write code to push the operand onto the stack
                                            
                                            

                                        }
                                        else {                                  
					// If it is an operator, you pop the top two values from the stack, perform the operation, and push the result back
                                        
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                        }
                                
					// Once this loop is done, the answer will be inside the stack.
					// Therefore, AFTER the loop (outside the loop), you should pop the stack one final time to get the answer
			//	result=postfixStack.pop();
                                
                                }
                                result=postfixStack.pop();
				System.out.println(">    You entered the Postfix expression:  " + postfix);
				System.out.println(">    This evaluates to " + result); // THIS is the FINAL POP to print the answer.
				// UN-COMMENT the above postfixStack.pop() to print the final value.
			}

			// ******************************************************************* //
			//                          LAB ACTIVITY #2                            //
			// ******************************************************************* //
			else if (choice == 7) {
				// Don't worry about the line below...we use it to advance the carriage return
				input.nextLine();
				// Make a new array-based stack
				PostFixStackArray postfixStack2 = new PostFixStackArray(15);
				System.out.println("Enter the Infix expression you wish to convert (type on one line and use spaces between all terms): ");
				System.out.println("     Example: 7 * 16 + 5 + 16 * 3 + 16 * 2 ");
				System.out.print("     Please enter the Infix expression:  ");
				
				// READ the entire infix expression (with spaces) into the String variable infix.
				// NOTE: we assume the expression is a LEGAL infix expression.
				//       So no need to check if illegal.
				infix = input.nextLine();
				System.out.println(">    You entered the Infix expression:  " + infix);
				System.out.print(">    Which converts to the following Postfix expression:  ");
				String postfixString=" ";
				// The following FOR loop is used to extract each token, examine it, and then perform some action.
				// Here, just so you understand, we print out each token.
				// Hopefully, it is clear what is going on.
				//    - The .split() method takes a string (infix) and will "split" it up into the different parts.
				//    - How does it "split" up the string? It does so based on the delimiter, which, in this case, is a space.
				// So on this example, we split the infix expression based on spaces, and we print each "token"
				for (String token: infix.split(" ")) {
				//	System.out.println(token); // DELETE this print statement after you understand what is going on
					
					// LAB ACTIVITY #2
					// PUT CODE HERE
					// You must write code to check the value of each token
					// If it is an operand (a number), you PRINT IT immediately
					// ELSE (it is an operator), you must follow the rules in the slides
					//    - You can PUSH if the stack is empty
					//    - You can PUSH if the new value is BIGGER/STROGER (high precedence)
					//      than the current value at the top of the stack
					//
					// THEN, after the FOR loop is complete, so OUTSIDE the for loop,
					// you should POP and PRINT all remaining operators on the stack.					
					
                                        //////////////////////////////////////////////////////////////////
                                         
                                        
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                } //End of for loop
                                while (!postfixStack2.isEmpty()) {
                                        char oper = postfixStack2.peek();
                                        if (oper != '(') {
                                                postfixStack2.pop();
                                                postfixString += oper;
                                        }
                                    
                                }        
                                        
                                        ////////////////////////////////////////////////////////////////
                                System.out.println("Postfix Expression "+postfixString);        
				
				System.out.println();
			}
			
			// Quit
			else if (choice == 8) {
				System.out.println(">    Goodbye!");
				System.out.println();
			}
			
			// Wrong choice
			else {
				System.out.println(">    Wrong selection. Try again.");
				System.out.println();
			}
			
		} while (choice != 8);
	}
	
	public static void showMenu() {
		System.out.println("|-----------------------------------------------|");
		System.out.println("|---------     Stack - Array (Menu)    ---------|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("|   1. Push an item into the stack              |");
		System.out.println("|   2. Pop (and print) an item from the stack   |");
		System.out.println("|   3. Peek (look at) the top item in the stack |");
		System.out.println("|   4. Search for an item in the stack          |");
		System.out.println("|   5. Print all nodes in the stack             |");
		System.out.println("|   6. Evaluate Postfix expression              |");
		System.out.println("|   7. Convert Infix to Postfix                 |");
		System.out.println("|   8. Quit                                     |");
		System.out.println("|-----------------------------------------------|");
		System.out.println();
		System.out.print("> Please enter your choice: ");
	}
	
}