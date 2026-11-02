// QueueLL.java
// Class from which we can create fully functional Queues (using linked lists)

package lab9;

public class QueueLL {
	// front: reference variable to the front of the queue (same as "head" of linked list)
    private Node front;
	private Node back;
    
    // CONSTRUCTOR
    public QueueLL() {
        front = null;
		back = null;
    }
	
	
	
	
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return front == null;
	}
	
	
	//
	// void | PrintQueue()
	//
	public void PrintQueue() {
		PrintQueue(front);
	}
	//
	// void | PrintQueue(Node)
	//
	private void PrintQueue(Node front) {
		// We need to traverse...so we need a help ptr
		Node helpPtr = front;
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
		return search(front, data);
	}
	//
	// boolean | search(QueueNode, int)
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
	// void | enqueue(int)
	//
	public void enqueue(int data) {
		if (isEmpty()) {
			front = back = enqueue(front, back, data);
		}
		else {
			back = enqueue(front, back, data);
		}
		
	}
	//
	// QueueNode | enqueue(QueueNode, QueueNode, int)
	//
	private Node enqueue(Node front, Node back, int data) {
		// Make a new QueueNode with "data" as the data value
		Node temp = new Node(data);
		
		// Now, if the list is empty, return the reference for temp
		// and save this reference into both "front" and "back"
		// Why? Since this is the only node in the queue, it will be the front and back node
		if (isEmpty()) {
			return temp;
		}
		// ELSE, the queue is not empty. We need to insert temp at the back of the queue.
		// So save the address of the new node into the next of back.
		// Then, make back "traverse" one node over, so it now points to the new back node.
		// Finally, return the updated address of back.
		else {
			back.setNext(temp);
			back = back.getNext();
			return back;
		}
	}
	
	
	//
	// QueueNode | dequeue()
	//
	public Node dequeue() {
		Node temp = front;
		front = dequeue(front);
		if (front == null)
			back = null;
		return temp;
	}
	//
	// QueueNode | dequeue(QueueNode)
	//
	private Node dequeue(Node front) {
		front = front.getNext();
		return front;
	}
	
	
	//
	// int | peek()
	//
	public int peek() {
		// Invoke the peek method with front as a parameter
		int frontValue = peek(front);
		
		// return topValue
		return frontValue;
	}
	//
	// int | peek(QueueNode)
	//
	private int peek(Node front) {
		// Return the data value of the front node.
		// You can see that we do NOT dequeue. We are only returning the data value.
		return front.getData();
	}
        //Find smallest and largest nodes in the queue
	public void SmallestLargest() {
		
                SmallestLargest(front);
        }
	private void SmallestLargest(Node front) {
		int smallest=front.getData();
                int largest=front.getData();
                
                while(front!=null)
                {
                    if ( smallest>front.getData())
                    {
                         smallest=front.getData();
                    }
                    if (largest<front.getData())
                    {
                         largest=front.getData();
                    }
                    front=front.getNext();
                }
                System.out.println();
                System.out.println("Smallest element in the queue is "+smallest);
                System.out.println("Largest element in the queue is "+largest);
                
	}
}
