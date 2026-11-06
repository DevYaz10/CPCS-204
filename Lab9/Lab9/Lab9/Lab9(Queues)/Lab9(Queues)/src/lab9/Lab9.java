// QueueLLDemo.java
// Program to test the queue (linked-list version)

package lab9;

import java.util.Scanner;

public class Lab9 {

	public static void main(String[] args) {
		// Make Scanner
		Scanner input = new Scanner(System.in);
		
		// Other variables
		int choice; // user choice
		int value;  // value to enqueue, dequeue, or search for
		
		// Make a new Linked List called myList
                QueueLL myQueue = new QueueLL();
		
		// Do/while loop showing menu, getting user choice, and performing actions
		do {
			// Show menu and get user choice
			showMenu();
			choice = input.nextInt();
			
			// ENQUEUE new node into queue
			if (choice == 1) {
				System.out.print(">    What value do you want to enqueue: ");
				value = input.nextInt();
				
				// Invoke push method with "value" as the parameter
				myQueue.enqueue(value);
				System.out.println(">    " + value + " was successfully enqueued into the queue.");
				System.out.println();
			}
			
			// DEQUEUE node from queue
			else if (choice == 2) {				
				// First, check to see if queue is empty.
				// IF it is, then we clearly cannot POP
				if (myQueue.isEmpty()) {
					System.out.println(">    Error: cannot perform dequeue (queue is empty).");
				}
				// ELSE, DEQUEUE the queue. The dequeue() method returns a reference to the dequeued node.
				// You can do whatever you want with this reference. Here, we simply print the Data value,
				// indicating that it has been dequeued from the stack.
				else {
					Node temp = myQueue.dequeue();
					System.out.println(">    " + temp.getData() + " has been dequeued from the queue.");
				}
				System.out.println();
			}
			
			// PEEK (look at) the 1st value of the queue...but do not actually dequeue
			else if (choice == 3) {
				// First, check to see if queue is empty.
				// IF it is, then we clearly cannot PEEK
				if (myQueue.isEmpty()) {
					System.out.println(">    Error: cannot peek at queue (queue is empty).");
				}
				// ELSE, we invoke the peek() method, which returns an int value, representing
				// the value at the front of the queue. If you prefer, you could have the peek() method
				// return a reference to the actual front node. This gives you more flexibility to print
				// a variety of data members, modify the node, etc.
				else {
					System.out.println(">    " + myQueue.peek() + " is the value at the top of the queue.");
				}
				System.out.println();
			}
			
			// Search for an item in the queue
			else if (choice == 4) {
				System.out.print(">    What value do you want to search for: ");
				value = input.nextInt();
				if (myQueue.search(value))
					System.out.println(">    " + value + " was found in the queue.");
				else
					System.out.println(">    " + value + " was not found in the queue.");
				System.out.println();
			}
			
			// Print all nodes in queue
			else if (choice == 5) {
				if (myQueue.isEmpty()) {
					System.out.println(">    Error: cannot print nodes (the queue is empty)");
					System.out.println();
				}
				else {
					System.out.println(">    Printing All Nodes:");
					System.out.print(">    ");
					myQueue.PrintQueue();
					System.out.println();
					System.out.println();
				}
			}
			
                        // Find smallest and largest nodes in the queue
			else if (choice == 6) {
				if (myQueue.isEmpty()) {
					System.out.println(">    Error: cannot find smallest and largest nodes in the queue (the queue is empty)");
					System.out.println();
				}
				else {
					System.out.println(">   Displaying smallest and largest Nodes:");
					System.out.print(">    ");
					myQueue.SmallestLargest();
					System.out.println();
					System.out.println();
				}
			}
			
			//*************************************************************************//
			//                            LAB 9 QUESTIONS                              //
			//*************************************************************************//
			
			// QUESTION 1:
			// Delete a node from a queue (using 2nd queue)
			// - The code below generates a queue of random integers.
			// - YOU should then WRITE a method that deletes a particular value from the queue.
			// - However, you can ONLY use enqueue() and dequeue() methods.
			// - This means you cannot delete the value and then "shift" elements over.
			// - To solve this question, you need a second queue. You will insert elements,
			//   one by one, into this second queue. As soon as you find the element that you 
			//   want to delete, you delete it (i.e. you do *not* enqueue*) it into the second
			//   queue. Then, you continue dequeue all remaining elements from the first
			//   queue and then enqueuing them into the second queue. Once this is done, all
			//   elements will be in the second queue and in the original order. If you want, 
			//   you can return them to the first queue with another loop that simply dequeues
			//   them from the second queue and enqueues them back into the first queue.
			else if (choice == 7) {
				// Make 2 queues:
				QueueLL q1 = new QueueLL();
				QueueLL q2 = new QueueLL();
				// Insert 100 random integers (between 1 and 1000) into the queue
				for (int i = 0; i < 100; i++) {
					q1.enqueue(1 + (int)(Math.random()*999));
				}
				
				System.out.println(">    Before deleting value, elements of the queue are as follows:");

				q1.PrintQueue();

				System.out.println();



				// Ask user to enter a value to delete from the queue
				System.out.print(">    Please enter an INT value to delete from the queue: ");
				int value2delete = input.nextInt();
				
				// ************************** YOUR CODE HERE **************************//
				// Write the code (loops) to solve Question 1.
				boolean deleted = false;
				while (!q1.isEmpty()) {
					int temp = q1.dequeue().getData();
					if (temp == value2delete && !deleted)
						deleted = true;		
					else
						q2.enqueue(temp);
				}

				while (!q2.isEmpty()) {
					q1.enqueue(q2.dequeue().getData());
				}

				System.out.println(">    After deleting value " + value2delete + ", elements of the queue 1 are as follows:");
				q1.PrintQueue();
				System.out.println();
				
				
				
				
				
				
				
				
				// AFTER the code, we can print that the value has been removed from the queeu
				System.out.println(">    The following value has been removed from the queeu: " + value2delete);
				System.out.println();
			}
			
			// QUESTION 2:
			else if (choice == 8) {
				// Make 1 queue:
				QueueLL q1 = new QueueLL();
				QueueLL q2 = new QueueLL();
				QueueLL q3 = new QueueLL();
				// Insert 100 random integers (between 1 and 1000) into the queue
				for (int i = 0; i < 100; i++) {
					q1.enqueue(1 + (int)(Math.random()*999));
				}
				
				// ************************** YOUR CODE HERE **************************//
				// Write the code to solve Question 2.
				System.out.println("Elements of queue 1 are as follows:");
				q1.PrintQueue();
				System.out.println();

				while (!q1.isEmpty()) {
					int temp = q1.dequeue().getData();
					if (temp % 2 == 0)
						q2.enqueue(temp);	
					else
						q3.enqueue(temp);
				}

				System.out.println("Elements of queue 2 are as follows:");
				q2.PrintQueue();
				System.out.println();

				System.out.println("Elements of queue 3 are as follows:");
				q3.PrintQueue();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				// We print the line below just to put a space on the output
				System.out.println();
			}
			
			// QUESTION 3:
			// Given a queue of integers, write code to REVERSE the order of the integers
			// inside the queue, and use a stack to help you with this process.
			// You can ONLY use enqueue, dequeue, push, and pop methods.
			else if (choice == 9) {
				// Make 1 queue and 1 stack:
				QueueLL q1 = new QueueLL();
				StackLL s1 = new StackLL();
				// Insert 100 random integers (between 1 and 1000) into the queue
				for (int i = 0; i < 100; i++) {
					q1.enqueue(1 + (int)(Math.random()*999));
				}
				
				// ************************** YOUR CODE HERE **************************//
				// Write the code to solve Question 3.
				System.out.println("Elements of queue are as follows:");
				q1.PrintQueue();
				System.out.println();

				// Step 1: dequeue every value of the queue and push it onto the stack
				while (!q1.isEmpty()) {
					s1.push(q1.dequeue().getData());
				}

				// Step 2: pop every value of the stack and enqueue it back into the queue.
				// A stack is LIFO, so the last value pushed comes out first => reversed order.
				while (!s1.isEmpty()) {
					q1.enqueue(s1.pop().getData());
				}

				System.out.println("Elements of queue after reversing are as follows:");
				q1.PrintQueue();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				System.out.println();
			}

			// Quit
			else if (choice == 10) {
				System.out.println(">    Goodbye!");
				System.out.println();
			}
			else {
				System.out.println(">    Wrong selection. Try again.");
				System.out.println();
			}
			
		} while (choice != 10);
	}
	
	public static void showMenu() {
		System.out.println("|--------------------------------------------------|");
		System.out.println("|------     Queue - Linked List (Menu)    ---------|");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|   1. Enqueue an item                             |");
		System.out.println("|   2. Dequeue (and print) an item                 |");
		System.out.println("|   3. Peek (look at) the 1st item in the queue    |");
		System.out.println("|   4. Search for an item in the queue             |");
		System.out.println("|   5. Print all nodes in the queue                |");
                System.out.println("|   6. Find smallest and largest nodes in the queue|");
		System.out.println("|   7. Delete node from queue (using 2nd queue)    |");
		System.out.println("|   8. Copy Even and Odd value queues              |");
		System.out.println("|   9. Reverse all elements in a queue             |");
		System.out.println("|   10. Quit                                       |");
		System.out.println("|--------------------------------------------------|");
		System.out.println();
		System.out.print("> Please enter your choice: ");
	}
}
