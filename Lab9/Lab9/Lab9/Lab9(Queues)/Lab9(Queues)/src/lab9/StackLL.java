// StackLL.java
// Class from which we can create fully functional Stacks (using linked lists)

package lab9;

public class StackLL {
	// top: reference variable to the top of the stack (same as "head" of linked list)
    private Node top;
    
    // CONSTRUCTOR
    public StackLL() {
        top = null;
    }
	
	
	/* Below are MANY methods that are used on stacks.
	 * 
	 * Examples:
	 * isEmpty, PUSH, POP, PEEK, and more.
	 */
	
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return top == null;
	}
	
	
	//
	// void | PrintStack()
	//
	public void PrintStack() {
		PrintStack(top);
	}
	//
	// void | PrintStack(StackNode)
	//
	private void PrintStack(Node top) {
		// We need to traverse...so we need a help ptr
		Node helpPtr = top;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print the data value of the node
			System.out.print(helpPtr.getData() + ", ");
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}
	
	
	//
	// boolean | search(int)
	//
	public boolean search(int data) {
		return search(top, data);
	}
	//
	// boolean | search(StackNode, int)
	//
	private boolean search(Node p, int data) {
		// To search, we must traverse. Therefore, we need helpPtr.
		Node helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getData() == data)
				return true;
			helpPtr = helpPtr.getNext(); // step one node over		
		}
		return false;
	}
	
	
	//
	// void | push(int)
	//
	public void push(int data) {
		top = push(top, data);
	}
	//
	// StackNode | push(StackNode, int)
	//
	private Node push(Node top, int data) {
		// Make a new StackNode with "data" as the data value
		// and set the "next" of this new node to the same address as top
		// * This is the same as addToFront() method for Linked Lists.
		top = new Node(data, top);
		
		// Now, return the newly updated top.
		return top;
	}
	
	
	//
	// StackNode | pop()
	//
	public Node pop() {
		// Save a reference to the current top node (because we will change where top points to)
		Node temp = top;
		
		// Now, invoke the pop method with top as a parameter.
		// This method will return a new top node.
		top = pop(top);
		
		// Finally, return temp, which is the previous top node that we just "popped" off the list.
		return temp;
	}
	//
	// StackNode | pop(StackNode)
	//
	private Node pop(Node top) {
		// Set top equal to the next node.
		// This will make top point to the 2nd node instead of the first node.
		top = top.getNext();
		
		// return the address/reference of the new top node
		return top;
	}
	
	
	//
	// int | peek()
	//
	public int peek() {
		// Invoke the peek method with top as a parameter
		int topValue = peek(top);
		
		// return topValue
		return topValue;
	}
	//
	// int | peek(StackNode)
	//
	private int peek(Node top) {
		// Return the data value of the top node.
		// You can see that we do NOT pop. We are only returning the data value.
		return top.getData();
	}
}
